package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty.department;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.DepartmentEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.DepartmentService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractDateProvider;

@SpringComponent
@PrototypeScope
public class DepartmentListEditDataProvider extends AbstractDateProvider
        <DepartmentEntity,
        DepartmentService> {

    @Autowired
    public DepartmentListEditDataProvider(DepartmentService service){
        setService(service);
    }

    @Override
    protected String getDefaultColumnName() {
        return "iddepartment";
    }
}
