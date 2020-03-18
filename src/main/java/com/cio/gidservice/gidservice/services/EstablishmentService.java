package com.cio.gidservice.gidservice.services;

import com.cio.gidservice.gidservice.entities.*;
import com.cio.gidservice.gidservice.repositories.EstablishmentRepository;
import com.cio.gidservice.gidservice.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {

    @Autowired
    private EstablishmentRepository establishmentRepository;
    @Autowired
    private ServicesRepository servicesRepository;

    public Establishment findEstablishment(String name) {
        return establishmentRepository.findEstablishmentByName(name);
    }
    public Establishment findEstablishment(Long id) {
        return establishmentRepository.getOne(id);
    }

    public Establishment findEstablishmentByKeywords(String keyword) {
        return establishmentRepository.findEstablishmentByDescriptionContains(keyword);
    }

    public void addServiceToEstablishment(com.cio.gidservice.gidservice.entities.Service service, String establishmentName) {
        /*Establishment establishment = findEstablishment(establishmentName);
        //service.setEstablishment(establishment);*/
        servicesRepository.save(service);
    }

    public void addEstablishment(Establishment establishment) {
        establishmentRepository.save(establishment);
    }

    public List<com.cio.gidservice.gidservice.entities.Service> getAllServicesByEstablishment(String name) {
        return servicesRepository.findAllByEstablishment_Name(name);
    }

    public List<Establishment> getAll() {
        return establishmentRepository.findAll();
    }

    public List<com.cio.gidservice.gidservice.entities.Service> findAllServicesByKeyword(String keyword){
        return servicesRepository.findServicesByDescriptionContainingOrNameContains(keyword, keyword);
    }

}
