package by.it.milosh.controllers;

import by.it.milosh.model.PhoneNumber;
import by.it.milosh.model.Role;
import by.it.milosh.model.Tariff;
import by.it.milosh.model.User;
import by.it.milosh.service.service.PhoneNumberService;
import by.it.milosh.service.service.TariffService;
import by.it.milosh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private PhoneNumberService phoneNumberService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String admin(Model model) {
        Long numberOfUsers = userService.numberOfUsers();
        model.addAttribute("numberOfUsers", numberOfUsers);
        return "admin/admin";
    }

    @RequestMapping(value = "/numbers", method = RequestMethod.GET)
    public String numbers(Model model) {
        List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
        phoneNumbers = phoneNumberService.findAll();
        model.addAttribute("phoneNumbers", phoneNumbers);
        model.addAttribute("phoneNumber", new PhoneNumber());
        return "admin/numbers";
    }

    @RequestMapping(value = "/addNumber", params = {"save"}, method = RequestMethod.POST)
    public String addNumber(@Valid @ModelAttribute("phoneNumber") PhoneNumber phoneNumber, BindingResult br) {
        if (br.hasErrors()) {
            return "/admin/numbers";
        }
        phoneNumber.setUsed(false);
        phoneNumberService.add(phoneNumber);
        return "redirect:/admin/numbers";
    }

    @RequestMapping(value = "/tariffs", method = RequestMethod.GET)
    public String tariffs(Model model) {
        List<Tariff> tariffs = new ArrayList<Tariff>();
        tariffs = tariffService.findAll();
        model.addAttribute("tariffs", tariffs);
        model.addAttribute("tariff", new Tariff());
        return "admin/tariffs";
    }

    @RequestMapping(value = "/addTariff", params = {"save"}, method = RequestMethod.POST)
    public String addTariff(@Valid @ModelAttribute("tariff") Tariff tariff, BindingResult br) {
        tariffService.add(tariff);
        return "redirect:/admin/tariffs";
    }

    @RequestMapping(value = "/abonents", method = RequestMethod.GET)
    public String abonents(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        //model.addAttribute("user", new User());
        return "admin/abonents";
    }

    /*
    @RequestMapping(value = "/userInfo", params = {"userInfo"}, method = RequestMethod.POST)
    public String userInfo(@Valid @ModelAttribute("user") User user, BindingResult br) {
        return "admin/userInfo";
    }
    */

    @RequestMapping(value = "/userInfo/{username}", method = RequestMethod.GET)
    public String userInfo(@PathVariable("username") String username, Model model) {
        User user = userService.findUserByUsername(username);
        model.addAttribute("user", user);
        return "admin/userInfo";

    }

}
