package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd;

import com.vaadin.data.*;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Grid;
import com.vaadin.ui.Notification;
import lombok.Getter;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.OptimisticLockingFailureException;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.app.HasLogger;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.BasicEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.DAO;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UserFriendlyDataException;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.components.ConfirmPopup;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract class AbstractPresenter<
        E extends BasicEntity,                      //entity
        S extends DAO<E>,       //service
        V extends AbstractView> //View
        implements HasLogger, Serializable{

    @Getter
    private final NavigationManager navigationManager;
    @Getter private final S service;
    @Getter private final Class<E> entityType;
    private FilterablePageableDataProvider<E,Object> dataProvider;
    private BeanFactory beanFactory;
    @Getter private V view;

    @Getter private BeanValidationBinder<E> binder;

    private int fatherId;

    // The model for the view. Not extracted to a class to reduce clutter. If
    // the model becomes more complex, it could be encapsulated in a separate
    // class.
    private E editItem;

    protected AbstractPresenter(NavigationManager navigationManager,
                                S service,
                                Class<E> entityType,
                                FilterablePageableDataProvider<E, Object> dataProvider,
                                BeanFactory beanFactory){
        this.service = service;
        this.navigationManager = navigationManager;
/*

        Map m =  navigationManager.getStateParameterMap("&");
        m.forEach((a,b) -> {
            System.out.println(a+" = "+b);
            fatherId = Integer.valueOf(a.toString());
        });
*/


        this.entityType = entityType;
        this.dataProvider = dataProvider;
        this.beanFactory = beanFactory;
        createBinder();
    }

    public void init(V view){
        this.view = view;
        view.setDataProvider(dataProvider);
        view.bindFormFields(getBinder());
        view.showInitialState();
    }

    protected void createBinder(){
        binder = new BeanValidationBinder<>(getEntityType());
        binder.addStatusChangeListener(this::onFormStatusChange);
    }

    public void viewEntered(ViewChangeEvent event) {
        if (!event.getParameters().isEmpty()) {
            editRequest(event.getParameters());
        }
    }

    public void beforeLeavingView(ViewBeforeLeaveEvent event) {
        runWithConfirmation(event::navigate, () -> {
            // Nothing special needs to be done if user aborts the navigation
        });
    }

    /**
     * Runs the given command if the form contains no unsaved changes or if the
     * user clicks ok in the confirmation dialog telling about unsaved changes.
     *
     * @param onConfirmation
     *            the command to run if there are not changes or user pushes
     *            {@literal confirm}
     * @param onCancel
     *            the command to run if there are changes and the user pushes
     *            {@literal cancel}
     * @return <code>true</code> if the {@literal confirm} command was run
     *         immediately, <code>false</code> otherwise
     */
    private void runWithConfirmation(Runnable onConfirmation, Runnable onCancel) {
        if (hasUnsavedChanges()) {
            ConfirmPopup confirmPopup = beanFactory.getBean(ConfirmPopup.class);
            confirmPopup.showLeaveViewConfirmDialog(view, onConfirmation, onCancel);
        } else {
            onConfirmation.run();
        }
    }

    private boolean hasUnsavedChanges() {
        return editItem != null && getBinder().hasChanges();
    }

    public void editRequest(String parameters) {
        long id;
        try {
            id = Long.parseLong(parameters);
        } catch (NumberFormatException e) {
            id = -1;
        }

        if (id == -1) {
            System.out.println("editRequest(String parameters) - editItem(createEntity());");
            editItem(createEntity());
        } else {
            selectAndEditEntity(loadEntity(id));
        }
    }

    public void editRequest(E entity) {
        runWithConfirmation(() -> {
            // Fetch a fresh item so we have the latest changes (less optimistic
            // locking problems)
            System.out.println("public void editRequest(E entity)");
            System.out.println("entity.getEntityId() - "+entity.getEntityId());
            E freshEntity = loadEntity(entity.getEntityId()); //  error stp1
            System.out.println("editRequest(String parameters) - editItem(freshEntity);");
            editItem(freshEntity);
        }, () -> {
            // Revert selection in grid
            Grid<E> grid = getView().getGrid();
            if (editItem == null) {
                grid.deselectAll();
            } else {
                grid.select(editItem);
            }
        });
    }

    private void selectAndEditEntity(E entity) {
        getView().getGrid().select(entity);
        editRequest(entity);
    }

    protected E loadEntity(long id) {
        return service.find((int)id);
    }

    protected void editItem(E item){
        if(item == null){
            throw new IllegalArgumentException("The entity to edit cannot be null");
        }
        this.editItem = item;

        System.out.println("Is NEW? "+ item.getEntityId());
        boolean isNew = item.getEntityId() == 0;
        if(isNew){
            navigationManager.updateViewParameter("new");
        } else {
            navigationManager.updateViewParameter(String.valueOf(item.getEntityId()));
        }

        getBinder().readBean(editItem);
        getView().editItem(isNew);
    }

    private E createEntity() {
        try {
            E entity = getEntityType().newInstance();
            fatherId = navigationManager.getCurrentEntityId();
            System.out.println("fatherid = " + fatherId);
            entity.setFatherId(fatherId);
            return entity;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new UnsupportedOperationException(
                    "Entity of type " + getEntityType().getName() + " is missing a public no-args constructor", e);
        }
    }

    protected void deleteEntity(E entity) {
        if (entity.getEntityId()==0) {
            throw new IllegalArgumentException("Cannot delete an entity which is not in the database");
        } else {
            service.delete(entity);
        }
    }


    private void revertToInitialState() {
        editItem = null;
        getBinder().readBean(null);
        getView().showInitialState();
        navigationManager.updateViewParameter("");
    }


    public void updateClicked() {
        try {
            // The validate() call is needed only to ensure that the error
            // indicator is properly shown for the field in case of an error
            getBinder().validate();
            getBinder().writeBean(editItem);
        } catch (ValidationException e) {
            // Commit failed because of validation errors
            List<BindingValidationStatus<?>> fieldErrors = e.getFieldValidationErrors();
            if (!fieldErrors.isEmpty()) {
                // Field level error
                HasValue<?> firstErrorField = fieldErrors.get(0).getField();
                getView().focusField(firstErrorField);
            } else {
                // Bean validation error
                ValidationResult firstError = e.getBeanValidationErrors().get(0);
                Notification.show(firstError.getErrorMessage(), Notification.Type.ERROR_MESSAGE);
            }
            return;
        }

        boolean isNew = editItem.getEntityId()==0;
        E entity;
        try {
            if (isNew)
                entity = service.save(editItem);
            else
                entity = service.update(editItem);
        } catch (OptimisticLockingFailureException e) {
            // Somebody else probably edited the data at the same time
            Notification.show("Somebody else might have updated the data. Please refresh and try again.",
                    Notification.Type.ERROR_MESSAGE);
            getLogger().debug("Optimistic locking error while saving entity of type "
                            + editItem.getClass().getName(), e);
            return;
        } catch (UserFriendlyDataException e) {
            Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
            getLogger().debug("Unable to update entity of type " + editItem.getClass().getName(), e);
            return;
        } catch (Exception e) {
            // Something went wrong, no idea what
            Notification.show("A problem occured while saving the data. Please check the fields.", Notification.Type.ERROR_MESSAGE);
            getLogger().error("Unable to save entity of type " + editItem.getClass().getName(), e);
            return;
        }

        System.out.println();
        if (isNew) {
            // Move to the "Updating an entity" state
            dataProvider.refreshAll();
            selectAndEditEntity(entity);
        } else {
            // Stay in the "Updating an entity" state
            dataProvider.refreshItem(entity);
            editRequest(entity);
        }
    }

    public void cancelClicked() {
        if (editItem.getEntityId()==0) {
            revertToInitialState();
        } else {
            editItem(editItem);
        }
    }

    public void deleteClicked() {
        try {
            deleteEntity(editItem);
        } catch (UserFriendlyDataException e) {
            Notification.show(e.getMessage(), Notification.Type.ERROR_MESSAGE);
            getLogger().debug("Unable to delete entity of type " + editItem.getClass().getName(), e);
            return;
        } catch (DataIntegrityViolationException e) {
            Notification.show("The given entity cannot be deleted as there are references to it in the database",
                    Notification.Type.ERROR_MESSAGE);
            getLogger().error("Unable to delete entity of type " + editItem.getClass().getName(), e);
            return;
        }
        dataProvider.refreshAll();
        revertToInitialState();
    }

    public void addNewClicked() {
        runWithConfirmation(() -> {
            E entity = createEntity();
            System.out.println("addNewClicked() - editItem(entity);");
            editItem(entity);
        }, () -> {
        });
    }

    public void backwardClicked(){
        navigationManager.navigateToBackward();
    }

    public E getSelectedItem(){
        return editItem;
    }

    protected void filterGrid(String filter) {
        dataProvider.setFilter(filter);
    }

    public void onFormStatusChange(StatusChangeEvent event) {
        boolean hasChanges = event.getBinder().hasChanges();
        boolean hasValidationErrors = event.hasValidationErrors();
        getView().setUpdateEnabled(hasChanges && !hasValidationErrors);
        getView().setCancelEnabled(hasChanges);
    }
}
