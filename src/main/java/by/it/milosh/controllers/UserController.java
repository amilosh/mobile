package by.it.milosh.controllers;

import by.it.milosh.model.*;
import by.it.milosh.service.service.PhoneNumberService;
import by.it.milosh.service.service.AddonService;
import by.it.milosh.service.service.TariffService;
import by.it.milosh.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
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
    private AddonService addonService;

    @Autowired
    private PhoneNumberService phoneNumberService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String personal(Model model, HttpSession session, Principal principal) {
        User user = (User) session.getAttribute("user");
        int numberOfTariffs = tariffService.findAll().size();
        model.addAttribute("numberOfTariffs", numberOfTariffs);
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
    public String connect(@Valid @ModelAttribute("tariff") Tariff tariff, BindingResult br, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        userService.connect(user, tariff);
        model.addAttribute("tariff", user.getTariff());
        model.addAttribute("userWrapper", new UserWrapper());
        return "user/connectAdvancePayment";
    }

    @RequestMapping(value = "/connectAdvancePayment", method = RequestMethod.POST)
    public String connectAdvancePayment(@ModelAttribute("userWrapper") UserWrapper userWrapper, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        userService.setBalance(user, userWrapper.getBalance());
        userService.save(user);
        return "redirect:/user";
    }

    @RequestMapping(value = "changeTariff", method = RequestMethod.GET)
    public String changeTariff(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        model.addAttribute("user", user);
        List<Tariff> tariffs = tariffService.findAll();
        model.addAttribute("tariffs", tariffs);
        model.addAttribute("tariff", new Tariff());
        model.addAttribute("emptyTariff", new Tariff());
        return "user/changeTariff";
    }

    @RequestMapping(value = "/changeTariff", params = {"changeTariff"}, method = RequestMethod.POST)
    public String changeTariff(@Valid @ModelAttribute("tariff") Tariff tariff, BindingResult br, Principal principal, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long tariffId = tariff.getTariffId();
        userService.addTariffToUser(user, tariffId);
        return "redirect:/user";
    }

    @RequestMapping(value = "/addons", method = RequestMethod.GET)
    public String addons(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Long userId = user.getUserId();
        List<Addon> addonsOfUser = userService.getAddonsOfUser(userId);
        model.addAttribute("addonsOfUser", addonsOfUser);
        return "user/addons";
    }

    @RequestMapping(value = "/connectAddons", method = RequestMethod.GET)
    public String connectAddons(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Addon> addonsNonUser = userService.getAddonsNonUser(user.getUserId());
        model.addAttribute("addonsNonUser", addonsNonUser);
        model.addAttribute("userWrapper", new UserWrapper());
        return "user/connectAddons";
    }

    @RequestMapping(value = "/connectAddons", method = RequestMethod.POST)
    public String connectAddons(@ModelAttribute("userWrapper") UserWrapper userWrapper, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        List<Long> addonIds = userWrapper.getAddonId();
        for (Long id : addonIds) {
            userService.addAddonToUser(user.getUserId(), id);
        }
        return "redirect:/user";
    }

    @RequestMapping(value = "/topUpBalance", method = RequestMethod.GET)
    public String topUpBalance(Model model) {
        model.addAttribute("userWrapper", new UserWrapper());
        return "user/topUpBalance";
    }

    @RequestMapping(value = "/topUpBalance", method = RequestMethod.POST)
    public String topUpBalance(@ModelAttribute("userWrapper") UserWrapper userWrapper, Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        userService.setBalance(user, userWrapper.getBalance());
        return "redirect:/user";
    }

}
