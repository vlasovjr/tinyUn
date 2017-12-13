package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.user;

import java.util.ArrayList;
import java.util.List;

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

@SpringComponent
@PrototypeScope
public class AdminUserDataProvider extends FilterablePageableDataProvider<UserEntity, Object> {

    private final UserService userService;

    @Autowired
    public AdminUserDataProvider(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected Page<UserEntity> fetchFromBackEnd(Query<UserEntity, Object> query, Pageable pageable) {
        return userService.findAnyMatching(getOptionalFilter(), pageable, "login");
    }

    @Override
    protected int sizeInBackEnd(Query<UserEntity, Object> query) {
        return (int) userService.countAnyMatching(getOptionalFilter(),"login");
    }

    @Override
    protected List<QuerySortOrder> getDefaultSortOrders() {
        List<QuerySortOrder> sortOrders = new ArrayList<>();
        sortOrders.add(new QuerySortOrder("login", SortDirection.ASCENDING));
        return sortOrders;
    }

}