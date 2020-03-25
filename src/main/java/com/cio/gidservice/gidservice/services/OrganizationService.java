package com.cio.gidservice.gidservice.services;

import com.cio.gidservice.gidservice.entities.*;
import com.cio.gidservice.gidservice.errors.NonAuthorizedAccess;
import com.cio.gidservice.gidservice.repositories.LogsRepository;
import com.cio.gidservice.gidservice.repositories.OrganizationRepository;
import com.cio.gidservice.gidservice.repositories.ServicesRepository;
import com.cio.gidservice.gidservice.repositories.UserRepository;
import org.apache.catalina.authenticator.NonLoginAuthenticator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private LogsRepository logsRepository;
    @Autowired
    private UserRepository userRepository;


    public List<Organization> findAllByUserId(Long id) throws NonAuthorizedAccess {
        return organizationRepository.findOrganizationsByUserId(id);
    }

    public Organization findOrganization(String name) {
        return organizationRepository.findOrganizationByName(name);
    }
    public Organization findOrganization(Long id) {
        return organizationRepository.getOne(id);
    }

    public Organization findOrganizationByKeywords(String keyword) {
        return organizationRepository.findOrganizationByDescriptionContains(keyword);
    }

    public void addServiceToOrganization(com.cio.gidservice.gidservice.entities.Service service, String organizationName) {
        /*Organization organization = findOrganization(organizationName);
        //service.setOrganization(organization);*/
        servicesRepository.save(service);
    }

    public void addOrganization(Long user_id, Organization organization) {
        //if(logsRepository.existsLogsByUser_id(user_id)) {
            User user = userRepository.getOne(user_id);
            user.addOrganization(organization);
            organization.setUser(user);
            organizationRepository.save(organization);
        //}
    }

    public List<com.cio.gidservice.gidservice.entities.Service> getAllServicesByOrganization(Long id) {
        return servicesRepository.findAllByOrganizationId(id);
    }

    public List<Organization> getAll() {
        return organizationRepository.findAll();
    }

    public List<com.cio.gidservice.gidservice.entities.Service> findAllServicesByKeyword(String keyword){
        return servicesRepository.findServicesByDescriptionContainingOrNameContaining(keyword, keyword);
    }

}
