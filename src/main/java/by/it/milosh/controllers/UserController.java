package by.it.milosh.controllers;

import by.it.milosh.model.PhoneNumber;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TariffService tariffService;

    @Autowired
    private PhoneNumberService phoneNumberService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String personal(Principal principal, Model model) {
        User user = userService.findUserByUsername(principal.getName());
        model.addAttribute("user", user);

        return "user/user";
    }

    @RequestMapping(value = "/connect", method = RequestMethod.GET)
    public String connect(Model model) {
        List<Tariff> tariffs = tariffService.findAll();
        model.addAttribute("tariffs", tariffs);
        model.addAttribute("tariff", new Tariff());
        return "user/connect";
    }

    @RequestMapping(value = "/connect", params = {"connect"}, method = RequestMethod.POST)
    public String connect(@Valid @ModelAttribute("tariff") Tariff tariff, BindingResult br, Principal principal) {
        User user = userService.findUserByUsername(principal.getName());
        Long tar_id = tariff.getTariff_id();
        userService.addTariffToUser(user, tar_id);
        List<PhoneNumber> phoneNumbers = phoneNumberService.findAllUnusedNumbers();
        PhoneNumber pn = phoneNumbers.get(0);
        userService.addNumberToUser(user, pn);
        return "redirect:/user";
    }

}
