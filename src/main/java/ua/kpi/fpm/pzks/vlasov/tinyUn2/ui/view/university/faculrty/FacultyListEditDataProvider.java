package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.FacultyEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.FacultyService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractDateProvider;

@SpringComponent
@PrototypeScope
public class FacultyListEditDataProvider extends AbstractDateProvider
        <FacultyEntity,
        FacultyService> {

    @Autowired
    public FacultyListEditDataProvider(FacultyService service){
        setService(service);
    }

    @Override
    protected String getDefaultColumnName() {
        return "idfaculty";
    }
}
