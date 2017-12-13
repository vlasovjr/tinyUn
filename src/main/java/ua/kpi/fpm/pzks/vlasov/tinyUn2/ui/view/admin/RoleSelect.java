package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin;

import com.vaadin.ui.ComboBox;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.Role;

public class RoleSelect extends ComboBox<String> {

    public RoleSelect() {
        setCaption("Role");
        setEmptySelectionAllowed(false);
        setItems(Role.getAllRoles());
        setTextInputAllowed(false);
    }
}
