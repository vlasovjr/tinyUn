package ua.kpi.fpm.pzks.vlasov.tinyUn2.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.vaadin.spring.events.annotation.EnableEventBus;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.app.security.SecurityConfig;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.*;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.AppUI;

import javax.persistence.Entity;

@SpringBootApplication(scanBasePackageClasses = {
        AppUI.class,
        Application.class,
        UserService.class,
        UserExtraContactsService.class,
        UniversityService.class,
        DepartmentService.class,
        FacultyService.class,
        SecurityConfig.class})
@EnableEventBus
public class Application extends SpringBootServletInitializer{

    public static final String APP_URL = "/";
    public static final String LOGIN_URL = "/login.html";
    public static final String LOGOUT_URL = "/login.html?logout";
    public static final String LOGIN_FAILURE_URL = "/login.html?error";
    public static final String LOGIN_PROCESSING_URL = "/login";

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application){
        return application.sources(Application.class);
    }
}
