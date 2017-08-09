package by.it.milosh.controllers;

import by.it.milosh.model.PhoneNumber;
import by.it.milosh.model.Role;
import by.it.milosh.model.User;
import by.it.milosh.service.service.PhoneNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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

}
