package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.user;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UserService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractDateProvider;

@SpringComponent
@PrototypeScope
public class AdminUserDataProvider extends AbstractDateProvider<UserEntity, UserService> {

    @Autowired
    public AdminUserDataProvider(UserService userService) {
        setService(userService);
    }

    @Override
    public boolean isChild(){
        return false;
    }

    @Override
    protected String getDefaultColumnName(){
        return "login";
    }

}