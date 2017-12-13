package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui;

import com.vaadin.addon.charts.ChartOptions;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.Viewport;
import com.vaadin.server.DefaultErrorHandler;
import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.spring.navigator.SpringViewProvider;
import com.vaadin.ui.UI;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.app.HasLogger;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.AccessDeniedView;

@Theme("tinyundefault")
@SpringUI
@Viewport("width=device-width,initial-scale=1.0,user-scalable=no")
@Title("tinyUn WorkSpace")
public class AppUI extends UI implements HasLogger {

    private final SpringViewProvider viewProvider;
    private final NavigationManager navigationManager;
    private final MainView mainView;

    @Autowired
    public AppUI(SpringViewProvider viewProvider, NavigationManager navigationManager, MainView mainView) {
        this.viewProvider = viewProvider;
        this.navigationManager = navigationManager;
        this.mainView = mainView;
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setErrorHandler(event -> {
            Throwable t = DefaultErrorHandler.findRelevantThrowable(event.getThrowable());
            getLogger().error("Error during request", t);
        });

        // Set the theme ("globally") for all Charts
        ChartOptions.get(this).setTheme(new ChartsTheme());

        viewProvider.setAccessDeniedViewClass(AccessDeniedView.class);
        setContent(mainView);

        navigationManager.navigateToDefaultView();
    }
}
