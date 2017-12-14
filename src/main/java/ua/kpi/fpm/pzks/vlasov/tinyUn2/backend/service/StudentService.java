package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service;

import org.springframework.stereotype.Service;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.StudentEntity;

@Service
public class StudentService extends DAO<StudentEntity>{
    public StudentService(){super();}
}
