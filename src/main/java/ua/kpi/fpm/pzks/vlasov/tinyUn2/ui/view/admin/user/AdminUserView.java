package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.user;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.ValidationResult;
import com.vaadin.data.Validator;
import com.vaadin.data.ValueContext;
import com.vaadin.data.validator.BeanValidator;
import com.vaadin.spring.annotation.SpringView;
import com.vaadin.ui.Button;
import com.vaadin.ui.Component;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextField;
import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractView;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.user.extra.contacts.EditUserExtraContactsView;

import javax.annotation.PostConstruct;


@SpringView(name="UserControlPanel")
public class AdminUserView extends AbstractView<UserEntity, AdminUserViewDesign, AdminUserPresenter> {

    private boolean passwordRequired;

    @Autowired
    public AdminUserView(AdminUserPresenter presenter) {
        setPresenter(presenter);
        setDesign(new AdminUserViewDesign());
    }

    @PostConstruct
    private void init() {
        getPresenter().init(this);
        getGrid().setColumns("login", "role", "firstName", "secondName");
        getGrid().addSelectionListener(e->{
            //System.out.println("rrr "+e.getFirstSelectedItem().get().getLogin());
            /*/--------------------------------------------------------------------------------------------------
            getViewComponent().extra.setVisible(true);
            if(e.getFirstSelectedItem().get().getUserExtraContactsByIduser().isEmpty()){
                //getViewComponent().extra.setVisible(true);
                getViewComponent().extra.setUserEntity(e.getFirstSelectedItem().get());
            }else {
                getViewComponent().extra.setUserEntity(e.getFirstSelectedItem().get());
            }

            //*/
        });
    }

    // X->X
    /**
     * Custom validator to be able to decide dynamically whether the password
     * field is required or not (empty value when updating the user is
     * interpreted as 'do not change the password').
     */
    private Validator<String> passwordValidator = new Validator<String>() {

        BeanValidator passwordBeanValidator = new BeanValidator(UserEntity.class, "password");

        @Override
        public ValidationResult apply(String value, ValueContext context) {
            if (!passwordRequired && value.isEmpty()) {
                // No password required and field is empty
                // OK regardless of other restrictions as the empty value will
                // not be used
                return ValidationResult.ok();
            } else {
                return passwordBeanValidator.apply(value, context);
            }
        }
    };

    //X->X
    public void setPasswordRequired(boolean passwordRequired) {
        this.passwordRequired = passwordRequired;
        getViewComponent().password.setRequiredIndicatorVisible(passwordRequired);
    }

    @Override
    public void bindFormFields(BeanValidationBinder<UserEntity> binder) {
        binder.forField(getViewComponent().password)
                .withValidator(passwordValidator)
                .bind(
                bean -> "",
                (bean, value) -> {
                    if (value.isEmpty()) {
                        // If nothing is entered in the password field, do
                        // nothing
                    } else {
                        bean.setPassword(getPresenter().encodePassword(value));
                    }
                });
        binder.bindInstanceFields(getViewComponent());
    }

    @Override
    protected Grid<UserEntity> getGrid() {
        return getViewComponent().list;
    }

    @Override
    protected void setGrid(Grid<UserEntity> grid) {
        getViewComponent().list = grid;
    }

    @Override
    protected Component getForm() {
        return getViewComponent().form;
    }

    @Override
    protected Button getAdd() {
        return getViewComponent().add;
    }

    @Override
    protected Button getCancel() {
        return getViewComponent().cancel;
    }

    @Override
    protected Button getDelete() {
        return getViewComponent().delete;
    }

    @Override
    protected Button getUpdate() {
        return getViewComponent().update;
    }

    @Override
    protected TextField getSearch() {
        return getViewComponent().search;
    }

    @Override
    protected Component.Focusable getFirstFormField() {
        return getViewComponent().login;
    }

    @Override
    protected void initExtraButton() {
        getExtraButton().clear();
        getExtraButton().add(getViewComponent().editExtraContacts);
    }

    @Override
    protected Button getBackward(){
        return null;
    }

    @Override
    protected void doubleClickOnGridEvent() {
        getPresenter().getNavigationManager().navigateToChild(
                EditUserExtraContactsView.class,
                getPresenter().getSelectedItem().getEntityId());
    }

    @Override
    protected void initExtraButtonClickListener() {
        getExtraButton().get(0).addClickListener(clickEvent -> {
            getPresenter().getNavigationManager().navigateToChild(
                    EditUserExtraContactsView.class,
                    getPresenter().getSelectedItem().getEntityId());
        });
    }

}