package by.it.milosh.config;

import by.it.milosh.model.Role;
import by.it.milosh.service.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class RolesInitialization {

    @Autowired
    private RoleService roleService;

    /*
    @PostConstruct
    public void init() {
        if (roleService.findAll().isEmpty()) {
            roleService.save(new Role("ROLE_ADMIN"));
            roleService.save(new Role("ROLE_USER"));
        }
    }
    */

}
