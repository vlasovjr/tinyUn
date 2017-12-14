package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UniversityEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractView;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty.FacultyListEditView;

import javax.annotation.PostConstruct;

@SpringView(name = "UniversityListEdit")
public class UniversityListEditView extends AbstractView
        <UniversityEntity,
        UniversityListEditViewDesign,
        UniversityListEditPresenter>{

    @Autowired
    public UniversityListEditView(UniversityListEditPresenter presenter){
        setDesign(new UniversityListEditViewDesign());
        setPresenter(presenter);
    }

    @PostConstruct
    private void init(){
        getPresenter().init(this);
        getGrid().setColumns("name");
    }

    @Override
    protected Grid<UniversityEntity> getGrid() {
        return getViewComponent().list;
    }

    @Override
    protected void setGrid(Grid<UniversityEntity> grid) {
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
        return null;
    }

    @Override
    protected void initExtraButton() {
        getExtraButton().clear();
        getExtraButton().add(getViewComponent().edit);
    }

    @Override
    protected void initExtraButtonClickListener() {
        getExtraButton().get(0).addClickListener(clickEvent -> {
           getPresenter().getNavigationManager().navigateToChild(
                   FacultyListEditView.class,
                   getPresenter().getSelectedItem().getEntityId());
        });
    }

    @Override
    protected TextField getSearch() {
        return getViewComponent().search;
    }

    @Override
    public void bindFormFields(BeanValidationBinder<UniversityEntity> binder) {
        binder.bindInstanceFields(getViewComponent());
    }
}
