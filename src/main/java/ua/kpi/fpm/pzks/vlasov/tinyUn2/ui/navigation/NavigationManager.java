package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation;


import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.spring.annotation.UIScope;
import com.vaadin.spring.internal.Conventions;
import com.vaadin.spring.navigator.SpringNavigator;
import org.springframework.stereotype.Component;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.EmptyPageView;
//import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.dashboard.DashboardView;
//import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.storefront.StorefrontView;

/**
 * Governs view navigation of the app.
 */
@Component
@UIScope
public class NavigationManager extends SpringNavigator {

    /**
     * Find the view id (URI fragment) used for a given view class.
     *
     * @param viewClass
     *            the view class to find the id for
     * @return the URI fragment for the view
     */
    public String getViewId(Class<? extends View> viewClass) {
        SpringView springView = viewClass.getAnnotation(SpringView.class);
        if (springView == null) {
            throw new IllegalArgumentException("The target class must be a @SpringView");
        }

        return Conventions.deriveMappingForView(viewClass, springView);
    }

    /**
     * Navigate to the given view class.
     *
     * @param targetView
     *            the class of the target view, must be annotated using
     *            {@link SpringView @SpringView}
     */
    public void navigateTo(Class<? extends View> targetView) {
        String viewId = getViewId(targetView);
        navigateTo(viewId);
    }

    public void navigateTo(Class<? extends View> targetView, Object parameter) {
        String viewId = getViewId(targetView);
        navigateTo(viewId + "/" + parameter.toString());
    }

    public void navigateToDefaultView() {
        // If the user wants a specific view, it's in the URL.
        // Otherwise admin goes to DashboardView and everybody else to
        // OrderListView
        if (!getState().isEmpty()) {
            return;
        }

       // navigateTo(SecurityUtils.isCurrentUserInRole(Role.ADMIN) ? DashboardView.class : StorefrontView.class);
        navigateTo(EmptyPageView.class);
    }

    /**
     * Update the parameter of the the current view without firing any
     * navigation events.
     *
     * @param parameter
     *            the new parameter to set, never <code>null</code>,
     *            <code>""</code> to not use any parameter
     */
    public void updateViewParameter(String parameter) {
        String viewName = getViewId(getCurrentView().getClass());
        String parameters;
        if (parameter == null) {
            parameters = "";
        } else {
            parameters = parameter;
        }

        updateNavigationState(new ViewChangeEvent(this, getCurrentView(), getCurrentView(), viewName, parameters));
    }

    private String backward = null;
    private int entityId = -1;

    public void navigateToChild(Class<? extends View> targetView, int entityId){
        this.backward = this.getState();
        this.entityId = entityId;
        System.out.println("\n\n\n\t\tALLERT\n"+entityId+"\n\n");
        String viewId = getViewId(targetView);
        navigateTo(viewId + "/");
    }

    public void navigateToBackward(){
        navigateTo(backward);
    }

    public int getCurrentEntityId(){
        return entityId;
    }

}
