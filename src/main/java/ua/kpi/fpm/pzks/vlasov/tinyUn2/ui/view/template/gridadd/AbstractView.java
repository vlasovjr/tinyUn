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
import com.vaadin.ui.components.grid.SingleSelectionModel;
import lombok.Getter;
import lombok.Setter;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.app.HasLogger;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.BasicEntity;

import javax.annotation.PostConstruct;
import java.io.Serializable;

public abstract class AbstractView <
        E extends BasicEntity,
        D extends Component>
        implements Serializable, View, HasLogger{

    @Getter
    @Setter
    private boolean isChild;

    @Getter
    @Setter
    private D design;

    @Getter
    @Setter
    private AbstractPresenter presenter;

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

    protected abstract TextField getSearch();

    public abstract void bindFormFields(BeanValidationBinder<E> binder);
}
