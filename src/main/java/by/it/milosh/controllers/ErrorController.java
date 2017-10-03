package by.it.milosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ErrorController {

    @RequestMapping(value = "/error/403", method = RequestMethod.GET)
    public String error403() {
        return "errors/403";
    }

    @RequestMapping(value = "/404", method = RequestMethod.GET)
    public String error404() {
        return "errors/404";
    }

    @RequestMapping(value = "/500", method = RequestMethod.GET)
    public String error500() {
        return "errors/500";
    }

}
