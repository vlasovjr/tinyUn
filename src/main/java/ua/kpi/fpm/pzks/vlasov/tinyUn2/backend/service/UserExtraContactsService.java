package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service;

import org.springframework.stereotype.Service;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserExtraContactsEntity;

import java.util.List;

@Service
public class UserExtraContactsService extends DAO<UserExtraContactsEntity>{

    public UserExtraContactsService() {
        super();
    }

    public List<UserExtraContactsEntity> findByUserId(int id){
        List<UserExtraContactsEntity> list;
        list = findAllBy("user_iduser", Integer.toString(id));
        return list;
    }


    /*
    //@Override
    public Page<UserEntity> findAnyMatching(Optional<String> filter, Pageable pageable) {
            if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            List<UserEntity> list = findAllBy("login", filter.get());
            Page<UserEntity> p = new PageImpl<UserEntity>(list, pageable, list.size());
            return p;
            } else {
            List<UserEntity> list = getAll();
            Page<UserEntity> p = new PageImpl<UserEntity>(list, pageable, list.size());
            return p;
            }
    }

    // @Override
    public long countAnyMatching(Optional<String> filter) {
            if (filter.isPresent()) {
            String repositoryFilter = "%" + filter.get() + "%";
            List<UserEntity> list = findAllBy("login", filter.get());
            return list.size();
            } else {
            List<UserEntity> list = getAll();//findAllBy("login", filter.get());
            return list.size();
            }
            }
//*/



}
