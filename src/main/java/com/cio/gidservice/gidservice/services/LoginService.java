package com.cio.gidservice.gidservice.services;

import com.cio.gidservice.gidservice.entities.databaseEntities.Logs;
import com.cio.gidservice.gidservice.entities.databaseEntities.User;
import com.cio.gidservice.gidservice.entities.requestEntities.UserRequestEntity;
import com.cio.gidservice.gidservice.repositories.LogsRepository;
import com.cio.gidservice.gidservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.time.LocalDateTime;

/**
 *
 */
@Service
public class LoginService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LogsRepository logsRepository;

    public void logOut(Long userID, String ip) {
        logsRepository.deleteAllLogsByUserIDAndIpEquals(userID, ip);
    }

    public Long trySignIn(Logs logs) {
        User user = userRepository.getOne(logs.getUserID());
        if(user.getPassword().equals(logs.getPassword())){
            logs.setTime(LocalDateTime.now());
            logsRepository.save(logs);
            return user.getId();
        }
        return null;
    }

    public boolean userExists(User user) {
        return userRepository.existsByLogin(user.getLogin());
    }
}
