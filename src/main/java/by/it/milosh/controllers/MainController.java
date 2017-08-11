package by.it.milosh.controllers;

import by.it.milosh.config.SecurityService;
import by.it.milosh.model.Role;
import by.it.milosh.model.Tariff;
import by.it.milosh.model.User;
import by.it.milosh.service.service.RoleService;
import by.it.milosh.service.service.TariffService;
import by.it.milosh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/main")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private SecurityService securityService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "main/main";
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "main/hello";
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser() {
        User user = new User("sasha");
        userService.add(user);
        return "main/hello";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return "main/user";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String error403() {
        return "403";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {

        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        return "main/login";
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        model.addAttribute("user", new User());
        return "main/registration";
    }

    @RequestMapping(value = "/registration", params = {"save"}, method = RequestMethod.POST)
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult br) {
        if (br.hasErrors()) {
            return "main/registration";
        }
        Role role = roleService.getById(2L);
        user.getRoles().add(role);
        userService.add(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());

        return "redirect:/";
    }

    @RequestMapping(value = "tariffs", method = RequestMethod.GET)
    public String tariffs(Model model) {
        List<Tariff> tariffs = tariffService.findAll();
        model.addAttribute("tariffs", tariffs);
        return "main/tariffs";
    }

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String personal(Principal principal) {
        String name = principal.getName();
        if(name.equals("admin")) {
            return "redirect:/admin";
        } else {
            return "redirect:/user";
        }
    }

}
