package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UniversityEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UniversityService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractDateProvider;

@SpringComponent
@PrototypeScope
public class UniversityListEditDataProvider extends AbstractDateProvider
        <UniversityEntity, UniversityService>{

    @Autowired
    public UniversityListEditDataProvider(UniversityService service){
        setService(service);
    }

    @Override
    protected String getDefaultColumnName() {
        return "iduniversity";
    }
}
