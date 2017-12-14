package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty.department.student.group;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.artur.spring.dataprovider.FilterablePageableDataProvider;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.StudentGroupInfoEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.StudentGroupInfoService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractPresenter;

@SpringComponent
@ViewScope
public class StudentGroupListEditPresenter extends AbstractPresenter
        <StudentGroupInfoEntity,
        StudentGroupInfoService,
        StudentGroupListEditView> {

    @Autowired
    protected StudentGroupListEditPresenter(NavigationManager navigationManager,
                                            StudentGroupInfoService service,
                                            StudentGroupListEditDataProvider dataProvider,
                                            BeanFactory beanFactory) {
        super(
                navigationManager,
                service,
                StudentGroupInfoEntity.class,
                dataProvider,
                beanFactory);


//        dataProvider.setFatherId(navigationManager.getCurrentEntityId());


    if(navigationManager.getCurrentEntityId() != -1){
            dataProvider.setChild(true);
            dataProvider.setFatherId(navigationManager.getCurrentEntityId());
        }else dataProvider.setChild(false);
        //*/
        System.out.println("\nGBPLF\n\t"+dataProvider.getFatherId());
    }
}
