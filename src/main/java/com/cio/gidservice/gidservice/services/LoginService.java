package com.cio.gidservice.gidservice.services;

import com.cio.gidservice.gidservice.entities.Logs;
import com.cio.gidservice.gidservice.entities.User;
import com.cio.gidservice.gidservice.repositories.LogsRepository;
import com.cio.gidservice.gidservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.time.LocalDateTime;

@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LogsRepository logsRepository;

    public void signOut(Long userID) {
        logsRepository.deleteAllByUserID(userID);
    }

    public boolean trySignIn(Logs logs) {
        try{
            User user = userRepository.getOne(logs.getUserID());
            if(user.getPassword().equals(logs.getPassword())){
                logs.setTime(LocalDateTime.now());
                logsRepository.save(logs);
                return true;
            }
        } catch (Exception e) {

        }
    }
}
