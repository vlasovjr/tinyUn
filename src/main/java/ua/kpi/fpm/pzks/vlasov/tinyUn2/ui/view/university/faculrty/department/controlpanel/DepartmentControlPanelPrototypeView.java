package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty.department.controlpanel;

import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringView;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.EmptyPageDesign;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.EmptyPageView;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty.department.student.group.StudentGroupListEditView;

@SpringView
public class DepartmentControlPanelPrototypeView
        extends DepartmentControlPanelPrototypeViewDesign
        implements View {

    private final NavigationManager navigationManager;

    @Autowired
    public DepartmentControlPanelPrototypeView(NavigationManager navigationManager){

        this.navigationManager = navigationManager;
        this.studentGroupListEdit.addClickListener(clickEvent -> {
            navigationManager.navigateToChild(
                    StudentGroupListEditView.class,
                    navigationManager.getCurrentEntityId());});

        this.backwardPage.addClickListener(clickEvent -> navigationManager.navigateToBackward());
    }


}
