package by.it.milosh.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

//@Controller
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    public ModelAndView handleError(Exception exception) {
        ModelAndView model = new ModelAndView();
        model.addObject("exception", exception);
        model.setViewName("errors/myError");
        return model;
    }


    @ExceptionHandler({IOException.class})
    public String databaseError() {
        return "errors/myError";
    }


}
