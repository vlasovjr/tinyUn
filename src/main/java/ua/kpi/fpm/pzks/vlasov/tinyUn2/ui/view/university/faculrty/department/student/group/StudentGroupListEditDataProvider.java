package ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.university.faculrty.department.student.group;

import com.vaadin.spring.annotation.SpringComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.vaadin.spring.annotation.PrototypeScope;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.StudentGroupInfoEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.StudentGroupInfoService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.ui.view.template.gridadd.AbstractDateProvider;

@SpringComponent
@PrototypeScope
public class StudentGroupListEditDataProvider extends AbstractDateProvider
        <StudentGroupInfoEntity,
        StudentGroupInfoService> {

    @Autowired
    public StudentGroupListEditDataProvider(StudentGroupInfoService service){
        setService(service);
    }

    @Override
    protected String getDefaultColumnName() {
        return "idstudentGroupInfo";
    }
}
