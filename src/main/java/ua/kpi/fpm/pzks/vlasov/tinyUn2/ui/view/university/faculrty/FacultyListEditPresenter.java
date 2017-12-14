package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.FacultyEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.FacultyService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractPresenter;

@SpringComponent
@ViewScope
public class FacultyListEditPresenter extends AbstractPresenter
        <FacultyEntity,
        FacultyService,
        FacultyListEditView>{

    @Autowired
    protected FacultyListEditPresenter(NavigationManager navigationManager,
                                       FacultyService service,
                                       FacultyListEditDateProvider dataProvider,
                                       BeanFactory beanFactory) {
        super(
                navigationManager,
                service,
                FacultyEntity.class,
                dataProvider,
                beanFactory);

        if(navigationManager.getCurrentEntityId() == -1) {
            dataProvider.setChild(true);
            dataProvider.setFatherId(navigationManager.getCurrentEntityId());
        }else dataProvider.setChild(false);
    }
}
