package com.cio.gidservice.gidservice.services;

import com.cio.gidservice.gidservice.entities.Logs;
import com.cio.gidservice.gidservice.entities.User;
import com.cio.gidservice.gidservice.repositories.LogsRepository;
import com.cio.gidservice.gidservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Long trySignIn(Logs logs) {
        try{
            User user = userRepository.getOne(logs.getUserID());
            if(user.getPassword().equals(logs.getPassword())){
                logs.setTime(LocalDateTime.now());
                logsRepository.save(logs);
                return user.getId();
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Long register(User user) {

    }
}
