package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service;

import org.springframework.stereotype.Service;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UniversityEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserExtraContactsEntity;

@Service
public class UniversityService extends DAO<UniversityEntity>{
    public UniversityService() {super();}
}
