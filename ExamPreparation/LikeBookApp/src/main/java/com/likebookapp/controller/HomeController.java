package com.likebookapp.controller;

import com.likebookapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
    private final LoggedUser loggedUser;

    public HomeController(LoggedUser loggedUser) {
        this.loggedUser = loggedUser;
    }

    @GetMapping("/")
    public ModelAndView index(){
        if (!loggedUser.isLogged()) {
            return new ModelAndView("index");
        } else {
            return new ModelAndView("redirect:/home");
        }
    }
}
