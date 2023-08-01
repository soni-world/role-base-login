package com.soni.rolebaselogin.controller;

import com.soni.rolebaselogin.model.UserInfo;
import com.soni.rolebaselogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/test")
    public String getWelcome(){
        return "Welcome Guest";
    }

    @PostMapping("/signup")
    public String signup(@RequestBody UserInfo userInfo){
        return userService.addUser(userInfo);
    }

    @DeleteMapping("/delete-user")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String deleteUser(@RequestParam String username){
        return userService.deleteUser(username);
    }
}
