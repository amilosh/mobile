package by.it.milosh.config;

import by.it.milosh.model.Role;
import by.it.milosh.model.User;
import by.it.milosh.service.service.RoleService;
import by.it.milosh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuthenticationService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    /*
    @Autowired
    private PasswordEncoder passwordEncoder;
    */

    @PostConstruct
    public void init() {
        if (userService.findUserByUsername("admin") == null) {
            User newUser = new User("admin","admin");
            //User newUser = new User("admin", passwordEncoder.encode("admin"));
            userService.add(newUser);

            Role newRole_1 = new Role("ROLE_ADMIN");
            Role newRole_2 = new Role("ROLE_USER");
            roleService.add(newRole_1);
            roleService.add(newRole_2);

            Role role_1 = (Role) roleService.getById(1L);
            Role role_2 = (Role) roleService.getById(2L);
            User user = (User) userService.getById(1L);
            user.getRoles().add(role_1);
            user.getRoles().add(role_2);
            userService.add(user);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findUserByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Username not found");
        }

        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }

        return new org.springframework.security.core.userdetails
                .User(user.getUsername(),
                      user.getPassword(),
                      true,
                      true,
                      true,
                      true,
                      authorities);
    }


}
