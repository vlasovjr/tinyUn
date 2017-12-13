package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.admin.user;

import com.vaadin.data.BeanValidationBinder;
import com.vaadin.data.StatusChangeEvent;
import com.vaadin.navigator.View;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.Button;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;

import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserExtraContactsEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UserExtraContactsService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UserService;

import org.vaadin.spring.events.EventBus.ViewEventBus;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.components.ConfirmPopup;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.navigation.NavigationManager;

import javax.annotation.PostConstruct;


@SpringComponent
@PrototypeScope
public class AdminUserExtraContactsView extends AdminUserExtraContactsViewDesign implements View {

    private final ViewEventBus viewEventBus;
    private final UserExtraContactsService userExtraContactsService;
    private final UserService userService;
    private final BeanFactory beanFactory;
    private BeanValidationBinder<UserExtraContactsEntity> binder;
    private UserExtraContactsEntity editItem;
    private final NavigationManager navigationManager;

    public static final String CAPTION_DISCARD = "Discard";
    public static final String CAPTION_CANCEL = "Cancel";
    public static final String CAPTION_UPDATE = "Update";
    public static final String CAPTION_ADD = "Add";

    private UserEntity userEntity;

    @Autowired
    public AdminUserExtraContactsView(ViewEventBus viewEventBus, UserExtraContactsService userExtraContactsService, UserService userService, BeanFactory beanFactory, NavigationManager navigationManager) {
        this.viewEventBus = viewEventBus;
        this.userExtraContactsService = userExtraContactsService;
        this.userService = userService;
        this.beanFactory = beanFactory;
        this.navigationManager = navigationManager;
    }

    @PostConstruct
    public void init(){
        System.out.println("\n\n");
        for(int i=0;i<10;i++)
            System.out.println("FUCK");
        BeanValidationBinder<UserExtraContactsEntity> binder = new BeanValidationBinder<>(UserExtraContactsEntity.class);
        System.out.println(binder);
        binder.addStatusChangeListener(this::onFormStatusChange);
        binder.setRequiredConfigurator(null); // Don't show a *
        //extraContacts.setDataProvider(dataP);
        binder.bindInstanceFields(this);
        this.showInitialState();
        //extra_add.setEnabled(true);
       // extra_add.addClickListener(clickEvent -> addNewExtraClicked());
        editItem = null;
    }

    public void setUserEntity(UserEntity userEntity){
        this.userEntity = userEntity;
//        extraContacts
       // extraContacts.setItems(userEntity.getUserExtraContactsByIduser());
    }

    public void addNewExtraClicked(){
        runWithConfirmation(() -> {
            UserExtraContactsEntity entity = createEntity();
            editItem(entity);
        }, () -> {
        });
    }

    private void runWithConfirmation(Runnable onConfirmation, Runnable onCancel) {
        if (hasUnsavedChanges()) {
            ConfirmPopup confirmPopup = beanFactory.getBean(ConfirmPopup.class);
            confirmPopup.showLeaveViewConfirmDialog(this, onConfirmation, onCancel);
        } else {
            onConfirmation.run();
        }
    }

    private boolean hasUnsavedChanges() {
        return editItem != null
                && binder.hasChanges();
    }

    private UserExtraContactsEntity createEntity() {
        try {
            return UserExtraContactsEntity.class.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new UnsupportedOperationException(
                    "Entity of type " + UserExtraContactsEntity.class.getName() + " is missing a public no-args constructor", e);
        }
    }


    protected void editItem(UserExtraContactsEntity item) {
        if (item == null) {
            throw new IllegalArgumentException("The entity to edit cannot be null");
        }
        this.editItem = item;

        boolean isNew = item.getIduserExtraContacts()==0;
        if (isNew) {
            navigationManager.updateViewParameter("new");
        } else {
            navigationManager.updateViewParameter(String.valueOf(item.getIduserExtraContacts()));
        }
        System.out.println(editItem);
        System.out.println(binder);
        binder.readBean(editItem);
        this.editItem(isNew);
    }

    public void editItem(boolean isNew) {
        if (isNew) {
           // extraContacts.deselectAll();
            update.setCaption(CAPTION_ADD);
            cancel.setCaption(CAPTION_CANCEL);
            type.focus();
        } else {
            update.setCaption(CAPTION_UPDATE);
            cancel.setCaption(CAPTION_DISCARD);
        }

        form.setEnabled(true);
        delete.setEnabled(!isNew);
    }

    public void onFormStatusChange(StatusChangeEvent event) {
        boolean hasChanges = event.getBinder().hasChanges();
        boolean hasValidationErrors = event.hasValidationErrors();
        this.setUpdateEnabled(hasChanges && !hasValidationErrors);
        this.setCancelEnabled(hasChanges);
    }

    public void setUpdateEnabled(boolean enabled) {
        update.setEnabled(enabled);
    }

    public void setCancelEnabled(boolean enabled) {
        cancel.setEnabled(enabled);
    }

    public void showInitialState() {
        form.setEnabled(false);
     //   extraContacts.deselectAll();
        update.setCaption(CAPTION_UPDATE);
        cancel.setCaption(CAPTION_DISCARD);
    }
}
