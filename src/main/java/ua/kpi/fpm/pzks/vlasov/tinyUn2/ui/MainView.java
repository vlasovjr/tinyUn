package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewDisplay;
import com.vaadin.navigator.ViewLeaveAction;
import com.vaadin.spring.access.SecuredViewAccessControl;
import com.vaadin.spring.annotation.SpringViewDisplay;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.ui.Button;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.user.AdminUserView;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.UniversityListEditView;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
//import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.product.ProductAdminView;
//import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.user.UserAdminView;
//import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.dashboard.DashboardView;
//import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.storefront.StorefrontView;

@SpringViewDisplay
@UIScope
public class MainView extends MainViewDesign implements ViewDisplay{

    private final Map<Class<? extends View>, Button> navigationButtons = new HashMap<>();
    private final NavigationManager navigationManager;
    private final SecuredViewAccessControl viewAccessControl;

    @Autowired
    public MainView(NavigationManager navigationManager, SecuredViewAccessControl viewAccessControl) {
        this.navigationManager = navigationManager;
        this.viewAccessControl = viewAccessControl;
    }

    @PostConstruct
    public void init() {
        //attachNavigation(storefront, StorefrontView.class);
        //attachNavigation(dashboard, DashboardView.class);
        attachNavigation(usersControlPanel, AdminUserView.class);
        attachNavigation(universityControlPanel, UniversityListEditView.class);
        //attachNavigation(products, ProductAdminView.class);

        logout.addClickListener(e -> logout());
    }

    /**
     * Makes clicking the given button navigate to the given view if the user
     * has access to the view.
     * <p>
     * If the user does not have access to the view, hides the button.
     *
     * @param navigationButton
     *            the button to use for navigatio
     * @param targetView
     *            the view to navigate to when the user clicks the button
     */
    private void attachNavigation(Button navigationButton, Class<? extends View> targetView) {
        boolean hasAccessToView = viewAccessControl.isAccessGranted(targetView);
        navigationButton.setVisible(hasAccessToView);

        if (hasAccessToView) {
            navigationButtons.put(targetView, navigationButton);
            navigationButton.addClickListener(e -> navigationManager.navigateTo(targetView));
        }
    }

    @Override
    public void showView(View view) {
        content.removeAllComponents();
        content.addComponent(view.getViewComponent());

        navigationButtons.forEach((viewClass, button) ->
                button.setStyleName("selected", viewClass == view.getClass()));

        Button menuItem = navigationButtons.get(view.getClass());
        String viewName = "";
        if(menuItem != null)
            viewName = menuItem.getCaption();

        activeViewName.setValue(viewName);
    }

    /**
     * Logs the user out after ensuring the currently open view has no unsaved
     * changes.
     */
    public void logout() {
        ViewLeaveAction doLogout = () -> {
            UI ui = getUI();
            ui.getSession().getSession().invalidate();
            ui.getPage().reload();
        };

        navigationManager.runAfterLeaveConfirmation(doLogout);
    }

}
