package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UniversityEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UniversityService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractPresenter;

@SpringComponent
@ViewScope
public class UniversityListEditPresenter extends AbstractPresenter
        <UniversityEntity,
        UniversityService,
        UniversityListEditView>{

    @Autowired
    public UniversityListEditPresenter(NavigationManager navigationManager,
                                       UniversityService service,
                                       UniversityListEditDataProvider dataProvider,
                                       BeanFactory beanFactory) {

        super(
                navigationManager,
                service,
                UniversityEntity.class,
                dataProvider,
                beanFactory);

        dataProvider.setChild(false);
    }
}
