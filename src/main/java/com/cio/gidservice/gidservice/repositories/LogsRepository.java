package com.cio.gidservice.gidservice.repositories;

import com.cio.gidservice.gidservice.entities.Logs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogsRepository extends JpaRepository<Logs, Long> {
    Boolean existsLogsByUserID(Long id);
    void deleteAllByUserID(Long id);
}
