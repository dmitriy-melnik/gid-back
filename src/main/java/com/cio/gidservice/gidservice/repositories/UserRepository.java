package com.cio.gidservice.gidservice.repositories;

import com.cio.gidservice.gidservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByPhoneNumber(String s);
}
