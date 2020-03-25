package com.cio.gidservice.gidservice.controllers;

import com.cio.gidservice.gidservice.entities.Logs;
import com.cio.gidservice.gidservice.entities.User;
import com.cio.gidservice.gidservice.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/login")
    public ResponseEntity<?> trySignIn(@RequestBody Logs logs) {
        try{
            return new ResponseEntity<>(loginService.trySignIn(logs), HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User user) {

    }
}
