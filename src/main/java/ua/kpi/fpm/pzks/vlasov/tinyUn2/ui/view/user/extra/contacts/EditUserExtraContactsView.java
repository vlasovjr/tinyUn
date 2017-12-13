package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.user.extra.contacts;


import com.vaadin.data.BeanValidationBinder;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserExtraContactsEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractView;

import javax.annotation.PostConstruct;


@SpringView(name = "EditUserExtraContacts")
public class EditUserExtraContactsView extends AbstractView<UserExtraContactsEntity, EditUserExtraContactsViewDesign>{

    //tmp
    @Override
    public void enter(ViewChangeEvent event) {
        String s = event.getParameters();
        System.out.println("\n\n" + s + "\n\n");
       // getDesign().test.setValue(s);
    }

    @Autowired
    public EditUserExtraContactsView(EditUserExtraContactsPresenter presenter){
        setDesign(new EditUserExtraContactsViewDesign());
        setPresenter(presenter);
    }

    @PostConstruct
    private void init(){
        getPresenter().init(this);
        getGrid().setColumns("type","contact","visibility");
    }

    @Override
    protected Grid<UserExtraContactsEntity> getGrid() {
        return getViewComponent().list;
    }

    @Override
    protected void setGrid(Grid<UserExtraContactsEntity> grid) {
        getViewComponent().list = grid;
    }

    @Override
    protected Component.Focusable getFirstFormField() {
        return getViewComponent().type;
    }

    @Override
    protected Component getForm() {
        return getViewComponent().form;
    }

    @Override
    protected Button getAdd() {
        return getViewComponent().add;
    }

    @Override
    protected Button getUpdate() {
        return getViewComponent().update;
    }

    @Override
    protected Button getCancel() {
        return getViewComponent().cancel;
    }

    @Override
    protected Button getDelete() {
        return getViewComponent().delete;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<UserExtraContactsEntity> binder) {
        binder.bindInstanceFields(getViewComponent());
    }

    @Override
    protected TextField getSearch() {
        return null;// getViewComponent().search;
    }

    //переопределение абстрактных методов

}
