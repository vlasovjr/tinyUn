package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty.department;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.DepartmentEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.DepartmentService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractPresenter;

@SpringComponent
@ViewScope
public class DepartmentListEditPresenter extends AbstractPresenter
        <DepartmentEntity,
        DepartmentService,
        DepartmentListEditView> {

    @Autowired
    public DepartmentListEditPresenter(NavigationManager navigationManager,
                                          DepartmentService service,
                                          DepartmentListEditDataProvider dataProvider,
                                          BeanFactory beanFactory) {
        super(
                navigationManager,
                service,
                DepartmentEntity.class,
                dataProvider,
                beanFactory);

        if(navigationManager.getCurrentEntityId() == -1){
            dataProvider.setChild(true);
            dataProvider.setFatherId(navigationManager.getCurrentEntityId());
        }else dataProvider.setChild(false);
    }
}
