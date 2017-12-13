package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.user.extra.contacts;


import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserExtraContactsEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UserExtraContactsService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractDateProvider;

@SpringComponent
@PrototypeScope
public class EditUserExtraContactsDataProvider extends AbstractDateProvider<
        UserExtraContactsEntity, UserExtraContactsService> {

    @Autowired
    public EditUserExtraContactsDataProvider(UserExtraContactsService userExtraContactsService){
        setService(userExtraContactsService);
        //setChild(false);
    }

    @Override
    protected String getDefaultColumnName() {
        return "userIduser";
    }
}
