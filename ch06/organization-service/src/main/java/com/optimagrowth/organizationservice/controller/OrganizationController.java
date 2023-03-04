package com.optimagrowth.organizationservice.controller;

import com.optimagrowth.organizationservice.model.Organization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.EurekaInstanceConfigBean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("v1/organization/{organizationId}")
public class OrganizationController {

    private final EurekaInstanceConfigBean eurekaInstanceConfigBean;

    public OrganizationController(EurekaInstanceConfigBean eurekaInstanceConfigBean) {
        this.eurekaInstanceConfigBean = eurekaInstanceConfigBean;
    }

    @GetMapping
    public ResponseEntity<Organization> get(@PathVariable("organizationId") String organizationId) {
        String instanceId = eurekaInstanceConfigBean.getInstanceId();
        log.info("get - instanceId = {}" + instanceId);
        Organization organization = new Organization()
                .setContactName("contactName")
                .setName("name")
                .setId(organizationId)
                .setContactEmail("email")
                .setContactPhone("phone");
        return ResponseEntity.ok(organization);
    }
}
