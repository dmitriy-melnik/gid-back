package com.cio.gidservice.gidservice.services;

import com.cio.gidservice.gidservice.model.Operation;
import com.cio.gidservice.gidservice.model.Organization;
import com.cio.gidservice.gidservice.repositories.OperationRepository;
import com.cio.gidservice.gidservice.repositories.OrganizationRepository;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    private final OrganizationRepository organizationRepository;
    private final UserService userService;
    private final OperationRepository operationRepository;

    @Autowired
    public OrganizationService(OrganizationRepository organizationRepository, UserService userService, OperationRepository operationRepository) {
        this.organizationRepository = organizationRepository;
        this.userService = userService;
        this.operationRepository = operationRepository;
    }

    public List<Organization> findAllByUserId(Long id) {
        return organizationRepository.findOrganizationsByUserId(id);
    }

    public List<Operation> getAllOperationsByOrganization(Long id) {
        return operationRepository.findAllByOrganizationId(id);
    }

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    public void addOrganization(Organization organization) {
        organizationRepository.save(organization);
    }

    public Organization findByName(String name) {
        return organizationRepository.findOrganizationByName(name);
    }

    public Organization findById(Long id) {
        return organizationRepository.findByOrganization_id(id);
    }

    public Long addOperationToOrganization(Operation operation, Long organizationId) {
        operation.setOrganization(findById(organizationId));
        operationRepository.save(operation);
        return operation.getOperation_id();
    }


}
