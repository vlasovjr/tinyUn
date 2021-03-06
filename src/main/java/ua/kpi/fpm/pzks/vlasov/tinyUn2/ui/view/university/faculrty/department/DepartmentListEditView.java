package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty.department;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.DepartmentEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractView;

import javax.annotation.PostConstruct;

@SpringView(name = "DepartmentListEdit")
public class DepartmentListEditView extends AbstractView
        <DepartmentEntity,
        DepartmentListEditViewDesign,
        DepartmentListEditPresenter> {

    @Autowired
    public DepartmentListEditView(DepartmentListEditPresenter presenter){
        setDesign(new DepartmentListEditViewDesign());
        setPresenter(presenter);
    }

    @PostConstruct
    private void init(){
        getPresenter().init(this);
        getGrid().setColumns("name");
    }

    @Override
    protected Grid<DepartmentEntity> getGrid() {
        return getViewComponent().list;
    }

    @Override
    protected void setGrid(Grid<DepartmentEntity> grid) {
        getViewComponent().list = grid;
    }

    @Override
    protected Component.Focusable getFirstFormField() {
        return getViewComponent().name;
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
    protected Button getBackward() {
        return getViewComponent().backwardPage;
    }

    @Override
    protected void initExtraButton() {
        getExtraButton().clear();
    }

    @Override
    protected void initExtraButtonClickListener() {

    }

    @Override
    protected TextField getSearch() {
        return getViewComponent().search;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<DepartmentEntity> binder) {
        binder.bindInstanceFields(getViewComponent());
    }
}
