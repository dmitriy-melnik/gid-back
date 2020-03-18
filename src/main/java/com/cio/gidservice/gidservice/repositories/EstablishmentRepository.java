package com.cio.gidservice.gidservice.repositories;

import com.cio.gidservice.gidservice.entities.Establishment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstablishmentRepository extends JpaRepository<Establishment, Long> {
    Establishment findEstablishmentByName(String s);
    Establishment findEstablishmentByDescriptionContains(String s);
}
