package com.graduation.web;

import com.graduation.model.User;
import com.graduation.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getUsers(HttpServletRequest request, @RequestParam(value = "action", defaultValue = "all") String action) {
        log.info("RUNNING getUsers method");

        if (action.equals("filter")) {
            String name = request.getParameter("name");
            return userService.getByName(name);
        } else {
            return userService.getAll();
        }
    }
}
