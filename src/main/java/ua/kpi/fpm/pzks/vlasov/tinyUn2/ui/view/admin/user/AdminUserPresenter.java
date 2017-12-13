package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.user;

import java.io.Serializable;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;

import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UserService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.AbstractCrudPresenter;

@SpringComponent
@ViewScope
public class AdminUserPresenter extends AbstractCrudPresenter<UserEntity, UserService, AdminUserView>
        implements Serializable {

    @Autowired
    public AdminUserPresenter(AdminUserDataProvider userAdminDataProvider, NavigationManager navigationManager,
                              UserService service, BeanFactory beanFactory) {
        super(navigationManager, service, UserEntity.class, userAdminDataProvider, beanFactory);
    }

    public String encodePassword(String value) {
        return getService().encodePassword(value);
    }

    @Override
    protected void editItem(UserEntity item) {
        super.editItem(item);
        getView().setPasswordRequired(item.getIduser()==0);
    }
}

