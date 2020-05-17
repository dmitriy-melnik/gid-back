package com.cio.gidservice.gidservice.repositories;

import com.cio.gidservice.gidservice.model.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OperationRepository extends JpaRepository<Operation, Long> {
    List<Operation> findAllByOrganizationId(Long l);
    List<Operation> findServicesByDescriptionContainingOrNameContaining(String s1, String s2);
}
