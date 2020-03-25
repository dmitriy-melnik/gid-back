package com.cio.gidservice.gidservice.controllers;

import com.cio.gidservice.gidservice.entities.Logs;
import com.cio.gidservice.gidservice.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
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
            if()
            return new ResponseEntity<>()
        } catch(Exception) {

        }
    }
}
