package com.optimagrowth.organizationservice.controller;

import com.optimagrowth.organizationservice.model.Organization;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/organization/{organizationId}")
public class OrganizationController {


    @GetMapping
    public ResponseEntity<Organization> get(@PathVariable("organizationId") String organizationId) {
        Organization organization = new Organization()
                .setContactName("contactName")
                .setName("name")
                .setId(organizationId)
                .setContactEmail("email")
                .setContactPhone("phone");
        return ResponseEntity.ok(organization);
    }
}
