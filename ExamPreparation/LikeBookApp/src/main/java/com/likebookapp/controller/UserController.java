package com.likebookapp.controller;

import com.likebookapp.model.UserLoginDTO;
import com.likebookapp.model.UserRegisterDTO;
import com.likebookapp.service.UserService;
import com.likebookapp.util.LoggedUser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    private final LoggedUser loggedUser;
    private final UserService userService;

    public UserController(LoggedUser loggedUser, UserService userService) {
        this.loggedUser = loggedUser;
        this.userService = userService;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }

    @PostMapping("/login")
    public ModelAndView login(UserLoginDTO userLoginDTO) {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        return new ModelAndView("login");
    }

    @GetMapping("/register")
    public ModelAndView register() {
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }

        return new ModelAndView("register");
    }

    @PostMapping("register")
    public ModelAndView register(UserRegisterDTO userRegisterDTO){
        if (loggedUser.isLogged()) {
            return new ModelAndView("redirect:/home");
        }
        boolean isRegistered = userService.register(userRegisterDTO);
    return new ModelAndView("register");
    }


}
