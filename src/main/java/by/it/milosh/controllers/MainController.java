package by.it.milosh.controllers;

import by.it.milosh.config.SecurityService;
import by.it.milosh.model.*;
import by.it.milosh.service.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
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
    private AddonService addonService;

    @Autowired
    private SecurityService securityService;

    @Autowired
    private CheckInitAdminService checkInitAdminService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main() {
        return "main/main";
    }

    @RequestMapping(value = "/fake", method = RequestMethod.GET)
    public String fake() throws Exception{
        int i = 1;
        if (i == 1) {
            throw new IOException("found IO Exception");
        }
        return "main/fake";
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String user() {
        return "main/user";
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
        userService.registrationUser(user);
        securityService.autoLogin(user.getUsername(), user.getPassword());
        return "redirect:/";
    }

    @RequestMapping(value = "/tariffs", method = RequestMethod.GET)
    public String tariffs(Model model) {
        List<Tariff> tariffs = tariffService.findAll();
        model.addAttribute("tariffs", tariffs);
        return "main/tariffs";
    }

    @RequestMapping(value = "/services", method = RequestMethod.GET)
    public String services(Model model) {
        List<Addon> addons = addonService.findAll();
        model.addAttribute("services", addons);
        return "main/services";
    }

    @RequestMapping(value = "/internet", method = RequestMethod.GET)
    public String internet() {
        return "main/internet";
    }

    @RequestMapping(value = "/personal", method = RequestMethod.GET)
    public String personal(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if(userService.isAdmin(user)) {
            return "redirect:/admin";
        } else {
            return "redirect:/user";
        }
    }

}
