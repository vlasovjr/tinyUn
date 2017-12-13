package ua.kpi.fpm.pzks.vlasov.tinyUn2.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.data.entity.UserEntity;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UserExtraContactsService;
import ua.kpi.fpm.pzks.vlasov.tinyUn2.backend.service.UserService;

import java.util.Collections;

//import com.gmail.t.backend.data.entity.User;
//import com.gmail.t.backend.service.UserService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;
    private final UserExtraContactsService userExtraContactsService;

    @Autowired
    public UserDetailsServiceImpl(UserService userService
            , UserExtraContactsService userExtraContactsService
    ) {
        this.userService = userService;
        this.userExtraContactsService = userExtraContactsService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userService.findByLogin(username);
        if (null == user) {
            throw new UsernameNotFoundException("No user present with username: " + username);
        } else {
            return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
                    Collections.singletonList(new SimpleGrantedAuthority(user.getRole())));
        }
    }
}