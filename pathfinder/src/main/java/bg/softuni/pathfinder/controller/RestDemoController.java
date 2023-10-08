package bg.softuni.pathfinder.controller;

import bg.softuni.pathfinder.model.User;
import bg.softuni.pathfinder.service.RestDemoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestDemoController {

    private final RestDemoService userService;

    public RestDemoController(RestDemoService userService) {
        this.userService = userService;
    }

    @RequestMapping(path = "/users/all", method = RequestMethod.GET)
    //@GetMapping("/users/all")
    public List<User> getAll() {
        return this.userService.getAll();
    }

}
