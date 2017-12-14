package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.HasValue;
import com.vaadin.data.provider.DataProvider;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewBeforeLeaveEvent;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import com.vaadin.ui.components.grid.ItemClickListener;
import com.vaadin.ui.components.grid.SingleSelectionModel;
import lombok.Getter;
import lombok.Setter;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.app.HasLogger;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.BasicEntity;

import javax.annotation.PostConstruct;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Base class for a CRUD (Create, read, update, delete) view.
 * <p>
 * The view has three states it can be in and the user can navigate between the
 * states with the controls present:
 * <ol>
 * <li>Initial state
 * <ul>
 * <li>Form is disabled
 * <li>Nothing is selected in grid
 * </ul>
 * <li>Adding an entity
 * <ul>
 * <li>Form is enabled
 * <li>"Delete" has no function
 * <li>"Discard" moves to the "Initial state"
 * <li>"Save" creates the entity and moves to the "Updating an entity" state
 * </ul>
 * <li>Updating an entity
 * <ul>
 * <li>Entity highlighted in Grid
 * <li>Form is enabled
 * <li>"Delete" deletes the entity from the database
 * <li>"Discard" resets the form contents to what is in the database
 * <li>"Save" updates the entity and keeps the form open
 * <li>"Save" and "Discard" are only enabled when changes have been made
 * </ol>
 *
 * @param <T>
 *            the type of entity which can be edited in the view
 */
public abstract class AbstractView <
        E extends BasicEntity,
        D extends Component,
        P extends AbstractPresenter>
        implements Serializable, View, HasLogger{

    @Getter
    @Setter
    private boolean isChild;

    @Getter
    @Setter
    private D design;

    @Getter
    @Setter
    private P presenter;

    @Getter
    List<Button> extraButton = new ArrayList<>();

    //Описывает названик кнопок
    public static final String CAPTION_DISCARD = "Discard";
    public static final String CAPTION_CANCEL = "Cancel";
    public static final String CAPTION_UPDATE = "Update";
    public static final String CAPTION_ADD = "Add";

    public void setDataProvider(DataProvider<E, Object> dataProvider) {
        getGrid().setDataProvider(dataProvider);
    }

    public D getViewComponent(){
        return design;
    }


    @Override
    public void enter(ViewChangeEvent event) {
        getPresenter().viewEntered(event);
    }

    @Override
    public void beforeLeave(ViewBeforeLeaveEvent event) {
        getPresenter().beforeLeavingView(event);
    }

    public void showInitialState() {
        getForm().setEnabled(false);
        getGrid().deselectAll();
        getUpdate().setCaption(CAPTION_UPDATE);
        getCancel().setCaption(CAPTION_DISCARD);
    }

    public void editItem(boolean isNew) {
        if (isNew) {
            getGrid().deselectAll();
            getUpdate().setCaption(CAPTION_ADD);
            getCancel().setCaption(CAPTION_CANCEL);
            getFirstFormField().focus();
        } else {
            getUpdate().setCaption(CAPTION_UPDATE);
            getCancel().setCaption(CAPTION_DISCARD);
        }

        getForm().setEnabled(true);
        getDelete().setEnabled(!isNew);
    }

    @PostConstruct
    private void initLogic() {
        initExtraButton();
        getGrid().addSelectionListener(e -> {
            if (!e.isUserOriginated()) {
                return;
            }

            if (e.getFirstSelectedItem().isPresent()) {
                getPresenter().editRequest(e.getFirstSelectedItem().get());
            } else {
                throw new IllegalStateException("This should never happen as deselection is not allowed");
            }
        });

        // Force user to choose save or cancel in form once enabled
        ((SingleSelectionModel<E>) getGrid().getSelectionModel()).setDeselectAllowed(false);

        // Button logic
        getUpdate().addClickListener(event -> getPresenter().updateClicked());
        getCancel().addClickListener(event -> getPresenter().cancelClicked());
        getDelete().addClickListener(event -> getPresenter().deleteClicked());
        getAdd().addClickListener(event -> getPresenter().addNewClicked());
        initExtraButtonClickListener();

        getGrid().addItemClickListener( e-> {
                    if (e.getMouseEventDetails().isDoubleClick())
                        doubleClickOnGridEvent(); });

        if(getBackward()!= null){
            getBackward().addClickListener(event -> getPresenter().backwardClicked());
        }

        //getExtraEdit().addClickListener(event -> getPresenter().extraEdit());

        // Search functionality
        //getSearch().addValueChangeListener(event -> getPresenter().filterGrid(event.getValue()));
    }


    public void setUpdateEnabled(boolean enabled) {
        getUpdate().setEnabled(enabled);
    }

    public void setCancelEnabled(boolean enabled) {
        getCancel().setEnabled(enabled);
    }


    public void focusField(HasValue<?> field) {
        if (field instanceof Component.Focusable) {
            ((Component.Focusable) field).focus();
        } else {
            getLogger().warn("Unable to focus field of type " + field.getClass().getName());
        }
    }


    protected abstract Grid<E> getGrid();
    protected abstract void setGrid(Grid<E> grid);

    protected abstract Component.Focusable getFirstFormField();

    protected abstract Component getForm();

    protected abstract Button getAdd();
    protected abstract Button getUpdate();
    protected abstract Button getCancel();
    protected abstract Button getDelete();
    protected abstract Button getBackward();

    protected abstract void doubleClickOnGridEvent();

    protected abstract void initExtraButton();
    protected abstract void initExtraButtonClickListener();

    protected abstract TextField getSearch();

    public abstract void bindFormFields(BeanValidationBinder<E> binder);
}
