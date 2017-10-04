package by.it.milosh.controllers;

import by.it.milosh.model.CheckInitAdmin;
import by.it.milosh.model.Role;
import by.it.milosh.model.Service;
import by.it.milosh.model.User;
import by.it.milosh.service.service.CheckInitAdminService;
import by.it.milosh.service.service.RoleService;
import by.it.milosh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StartController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    CheckInitAdminService checkInitAdminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "main/main";
    }

    @RequestMapping(value = "/setup", method = RequestMethod.GET)
    public String setup(Model model) {
        model.addAttribute("user", new User());
        return "main/setup";
    }

    @RequestMapping(value = "/setup", params = {"save"}, method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult br) {
        if (br.hasErrors()) {
            return "main/registration";
        }
        Role role = roleService.getById(1L);
        user.getRoles().add(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setAccount(0);
        userService.add(user);
        checkInitAdminService.add(new CheckInitAdmin(true));

        return "redirect:/";
    }

}
