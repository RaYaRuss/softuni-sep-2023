package bg.softuni.battleships.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String loggedOurIndex() {
        return "index";
    }
    @GetMapping("/home")
    public String loggedInIndex() {
        return "home";
    }
}
