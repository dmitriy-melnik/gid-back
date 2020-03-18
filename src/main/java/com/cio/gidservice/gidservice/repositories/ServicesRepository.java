package com.cio.gidservice.gidservice.repositories;

import com.cio.gidservice.gidservice.entities.Service;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServicesRepository extends JpaRepository<Service, Long> {
    List<Service> findAllByEstablishment_Name(String s);
    List<Service> findServicesByDescriptionContainingOrNameContaining(String s1, String s2);
}

