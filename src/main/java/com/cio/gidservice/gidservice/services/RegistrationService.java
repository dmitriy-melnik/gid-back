package com.cio.gidservice.gidservice.services;

import com.cio.gidservice.gidservice.entities.User;
import com.cio.gidservice.gidservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistrationService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByPhone(String phone) {
        return userRepository.getUserByPhoneNumber(phone);
    }
}
