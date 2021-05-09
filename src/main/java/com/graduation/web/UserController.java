package com.graduation.web;

import com.graduation.model.User;
import com.graduation.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/rest/users")
@PreAuthorize("hasRole('ADMIN')")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary="Get All Users")
    public List<User> getAll() {
        log.info("RUNNING getUsers method");
        return userService.getAll();
    }

    @GetMapping("/by/name")
    @Operation(summary="Get User By Name")
    public List<User> getByName(@RequestParam String name) {
        log.info("RUNNING getByName method");
        return userService.getByName(name);
    }

    @GetMapping("/by/id")
    @Operation(summary="Get User By Id")
    public User getById(@RequestParam int id) {
        log.info("RUNNING getById method");
        return userService.getById(id);
    }
}
