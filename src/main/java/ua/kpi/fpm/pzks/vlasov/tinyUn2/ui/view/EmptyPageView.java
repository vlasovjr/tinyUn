package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.spring.annotation.SpringView;

@SpringView(name = "")
public class EmptyPageView extends EmptyPageDesign implements View {
    @Override
    public void enter(ViewChangeListener.ViewChangeEvent event) {
        // Nothing to do, just show the view
    }
}
