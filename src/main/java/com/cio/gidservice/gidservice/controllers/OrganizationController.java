package com.cio.gidservice.gidservice.controllers;

import com.cio.gidservice.gidservice.entities.Organization;
import com.cio.gidservice.gidservice.entities.Service;
import com.cio.gidservice.gidservice.errors.NonAuthorizedAccess;
import com.cio.gidservice.gidservice.services.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping("/{user_id}/getAllOrganization")
    public List<Organization> getAllForUser(@PathVariable Long user_id,
                                           @RequestBody String ip){

        try{
            return organizationService.findAllByUserId(user_id);
        } catch (NonAuthorizedAccess nonAuthorizedAccess) {
            return null;
        }
    }

    @PostMapping("/{user_id}/addOrganization")
    public ResponseEntity<?> addEntity(@PathVariable Long user_id,
                                       @RequestBody Organization organization) {
        try{
            organizationService.addOrganization(user_id, organization);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/{user_id}/addService")
    public ResponseEntity<?> addServiceToOrganization(@PathVariable Long user_id,
                                                      @RequestParam(value = "organization_id") String name,
                                                      @RequestBody Service service) {
        try{
            Organization forReturn = organizationService.findOrganization(name);
            service.setOrganization(forReturn);
            organizationService.addServiceToOrganization(service, forReturn.getName());
            return new ResponseEntity<>(forReturn, HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>("User or organization not found!", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{user_id}/getServices")
    public ResponseEntity<?> getServicesByOrganization(@PathVariable String user_id,
                                                   @RequestParam(value = "organization_id") Long orgId) {
        try{
            return new ResponseEntity<>(organizationService.getAllServicesByOrganization(orgId), HttpStatus.OK);
        } catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NON_AUTHORITATIVE_INFORMATION);
        }
    }
}
