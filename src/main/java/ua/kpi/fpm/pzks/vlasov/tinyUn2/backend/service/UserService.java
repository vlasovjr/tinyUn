package ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserEntity;

import java.util.List;
import java.util.Optional;

@Service
public class UserService extends DAO<UserEntity>{
    public UserService() {
        super();
        passwordEncoder = null;
        userExtraContactsService = null;
    }

    private final PasswordEncoder passwordEncoder;
    private final UserExtraContactsService userExtraContactsService;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, UserExtraContactsService userExtraContactsService) {
        super();
        this.passwordEncoder = passwordEncoder;
        this.userExtraContactsService = userExtraContactsService;
    }

    public UserEntity findByLogin(String login){
        UserEntity ue =
       findOneBy("login", login);
       // find(1);

       System.out.println("\n\n\n\n"+ue.getLogin());
       System.out.println(ue.getPassword());
       System.out.println(passwordEncoder.encode("student1"));
       System.out.println(ue.getUserExtraContactsByIduser().isEmpty());
       //System.out.println(ue.getPassword());
       System.out.println(ue.getRole());
        return ue;
    }

    public String encodePassword(String value) {
        return passwordEncoder.encode(value);
    }


}
