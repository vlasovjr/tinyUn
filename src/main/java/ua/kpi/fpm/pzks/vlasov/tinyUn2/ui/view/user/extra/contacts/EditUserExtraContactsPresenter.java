package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.user.extra.contacts;

import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.spring.annotation.ViewScope;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserExtraContactsEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UserExtraContactsService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractPresenter;

@SpringComponent
@ViewScope
public class EditUserExtraContactsPresenter extends AbstractPresenter<
        UserExtraContactsEntity,
        UserExtraContactsService,
        EditUserExtraContactsView>{

    @Autowired
    public EditUserExtraContactsPresenter(NavigationManager navigationManager,
                                          UserExtraContactsService service,
                                          EditUserExtraContactsDataProvider editUserExtraContactsDataProvider,
                                          BeanFactory beanFactory) {
        super(
                navigationManager,
                service,
                UserExtraContactsEntity.class,
                editUserExtraContactsDataProvider,
                beanFactory);

        if(navigationManager.getCurrentEntityId()== -1){
            editUserExtraContactsDataProvider.setChild(false);
        }else{
            editUserExtraContactsDataProvider.setChild(true);
            editUserExtraContactsDataProvider.setFatherId(navigationManager.getCurrentEntityId());
        }


    }

    @Override
    protected void editItem(UserExtraContactsEntity item){
        super.editItem(item);
    }
}
