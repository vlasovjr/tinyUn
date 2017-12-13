package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.user;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import org.vaadin.spring.annotation.PrototypeScope;
import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import com.vaadin.spring.annotation.SpringComponent;

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