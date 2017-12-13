package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.components;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadin.dialogs.DefaultConfirmDialogFactory;

import java.util.Arrays;
import java.util.List;

/**
 * Singleton factory for creating the "are you sure"-type confirmation dialogs
 * in the application.
 */
@SpringComponent
public class ConfirmDialogFactory extends DefaultConfirmDialogFactory {

    @Override
    protected List<Button> orderButtons(Button cancel, Button notOk, Button ok) {
        return Arrays.asList(ok, cancel);
    }

    @Override
    protected Button buildOkButton(String okCaption) {
        Button okButton = super.buildOkButton(okCaption);
        okButton.addStyleName(ValoTheme.BUTTON_DANGER);
        return okButton;
    }
}
