package com.graduation.web;

import com.graduation.model.User;
import com.graduation.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Tag(name = "Users", description = "Users API")
@PreAuthorize("hasRole('ADMIN')")
@Slf4j
@RequestMapping("/rest/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @Operation(summary = "Get All Users")
    public List<User> getAll() {
        log.info("Getting All Users");
        return userService.getAll();
    }

    @GetMapping("/by/name")
    @Operation(summary = "Get User By Name")
    public List<User> getByName(@RequestParam String name) {
        log.info("Getting User With Name = " + name);
        return userService.getByName(name);
    }

    @GetMapping("/by/id")
    @Operation(summary = "Get User By Id")
    public User getById(@RequestParam int id) {
        log.info("Getting User With Id = " + id);
        return userService.getById(id);
    }
}
