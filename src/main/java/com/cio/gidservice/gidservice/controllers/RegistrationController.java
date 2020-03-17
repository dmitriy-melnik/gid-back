package com.cio.gidservice.gidservice.controllers;

import com.cio.gidservice.gidservice.entities.User;
import com.cio.gidservice.gidservice.services.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class RegistrationController {

    @Autowired
    private RegistrationService regService;

    @GetMapping("/auth")
    public User checkUserByPhone(@RequestBody User user) {
        System.out.println(user);
        User user1 = regService.getUserByPhone(user.getPhoneNumber());
        if (user.getPassword().equals(user1.getPassword())) {
            return regService.getUserByPhone(user.getPhoneNumber());
        } else return new User() {{
            setId(null);
        }};
    }
}
