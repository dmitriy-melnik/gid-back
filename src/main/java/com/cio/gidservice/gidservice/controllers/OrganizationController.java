package com.cio.gidservice.gidservice.controllers;

import com.cio.gidservice.gidservice.dto.OperationRequestDto;
import com.cio.gidservice.gidservice.dto.OrganizationRequestDto;
import com.cio.gidservice.gidservice.model.Operation;
import com.cio.gidservice.gidservice.model.Organization;
import com.cio.gidservice.gidservice.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @PostMapping("/addOrganization")
    public ResponseEntity<?> addEntity(@RequestBody OrganizationRequestDto organizationDto) {
        Organization organization = new Organization();
        organization.setOrganization_id(organizationDto.organization_id);
        organization.setName(organizationDto.name);
        organization.setPhoneNumber(organizationDto.getPhoneNumber());
        organization.setEmail(organizationDto.getEmail());
        organization.setDescription(organizationDto.getDescription());
        organization.setRating(organization.getRating());
        organizationService.addOrganization(organization);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/getAllOrganizations")
    public List<Organization> getAllOrganization() {
        return organizationService.getAll();
    }

    @PostMapping("/addOperation/{orr_id}")
    public ResponseEntity<?> addServiceToOrganization(@PathVariable Long id,
                                                      @RequestBody Operation operation) {

        if (organizationService.findById(id) != null) {
            organizationService.addOperationToOrganization(operation, id);
            return new ResponseEntity<>(id, HttpStatus.OK);
        } else return new ResponseEntity<>("User or organization not found!", HttpStatus.NOT_FOUND);

    }

    @GetMapping("/getOperationsByOrganization/{org_id}")
    public  ResponseEntity<?> getAllServicesByOrganization(@PathVariable Long orgId) {
        try{
            return new ResponseEntity<>(organizationService.getAllOperationsByOrganization(orgId), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
