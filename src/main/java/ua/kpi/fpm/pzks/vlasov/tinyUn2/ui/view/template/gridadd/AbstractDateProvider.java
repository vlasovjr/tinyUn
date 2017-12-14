package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd;

import com.vaadin.data.provider.Query;
import com.vaadin.data.provider.QuerySortOrder;
import com.vaadin.shared.data.sort.SortDirection;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.BasicEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.DAO;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractDateProvider<E extends BasicEntity, S extends DAO<E>> extends FilterablePageableDataProvider<E, Object> {

    @Getter
    @Setter
    private S service;

    @Getter
    @Setter
    private boolean isChild = false;

    @Setter
    @Getter
    private int fatherId = -1;

    @Override
    protected Page<E> fetchFromBackEnd(Query<E, Object> query, Pageable pageable) {
        System.out.println("gate page" + isChild + " "+fatherId);
        if(isChild)
            return getService().findAnyMatching(getOptionalFilter(), pageable,getDefaultColumnName(),getFatherId());
        else
            return getService().findAnyMatching(getOptionalFilter(), pageable,getDefaultColumnName());
    }

    @Override
    protected int sizeInBackEnd(Query<E, Object> query) {
        if(isChild)
            return (int) getService().countAnyMatching(getOptionalFilter(),getDefaultColumnName(),getFatherId());
        else
            return (int) getService().countAnyMatching(getOptionalFilter(),getDefaultColumnName());
    }

    @Override
    protected List<QuerySortOrder> getDefaultSortOrders() {
        if(isChild) {
            List<QuerySortOrder> sortOrders = new ArrayList<>();
            sortOrders.add(new QuerySortOrder(getDefaultColumnName(), SortDirection.ASCENDING));
            return sortOrders;
        }
        else {
            List<QuerySortOrder> sortOrders = new ArrayList<>();
            sortOrders.add(new QuerySortOrder(getDefaultColumnName(), SortDirection.ASCENDING));
            return sortOrders;
        }
    }

    protected abstract String getDefaultColumnName();
}
