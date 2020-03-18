package com.cio.gidservice.gidservice.controllers;

import com.cio.gidservice.gidservice.entities.Establishment;
import com.cio.gidservice.gidservice.entities.Service;
import com.cio.gidservice.gidservice.services.EstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EstablishmentController {

    @Autowired
    private EstablishmentService establishmentService;

    @PostMapping("/addEstablishment")
    public ResponseEntity<Establishment> addEntity(@RequestBody Establishment establishment) {
        System.out.println(establishment);
        establishmentService.addEstablishment(establishment);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addService")
    public ResponseEntity<Establishment> addServiceToEstablishment(@RequestParam(value="establishment_name") String name,
                                                                   @RequestBody Service service) {

        Establishment forReturn = establishmentService.findEstablishment(name);
        service.setEstablishment(forReturn);
        establishmentService.addServiceToEstablishment(service, forReturn.getName());
        return new ResponseEntity<Establishment>(forReturn, HttpStatus.OK);
    }

    @GetMapping("/get-all")
    public List<Establishment> getAllEstablishment() {
        return establishmentService.getAll();
    }

    @GetMapping("/getAllByEstablishment")
    public List<Service> getAllByEstablishment(@RequestParam String name) {
        return establishmentService.getAllServicesByEstablishment(name);
    }

    @GetMapping("/findServicesByWord")
    public List<Service> getAllServicesByWords(@RequestParam String keyword) {
        System.out.println(keyword);
        return establishmentService.findAllServicesByKeyword(keyword);
    }
}
