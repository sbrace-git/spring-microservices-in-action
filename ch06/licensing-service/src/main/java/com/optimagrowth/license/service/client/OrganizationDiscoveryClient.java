package com.optimagrowth.license.service.client;

import com.optimagrowth.license.model.Organization;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Component
public class OrganizationDiscoveryClient {

    private final DiscoveryClient discoveryClient;

    private final RestTemplate restTemplate;

    public OrganizationDiscoveryClient(DiscoveryClient discoveryClient,@Qualifier("restTemplateWithOutLoadBalanced") RestTemplate restTemplate) {
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    public Organization getOrganization(String organizationId) {
//        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("organization-service");

//        log.info("OrganizationDiscoveryClient instances = {}", instances);
        instances.forEach(instance -> log.info("getOrganization - instance = {}", instance));

        if (instances.size() == 0) return null;
        String serviceUri = String.format("%s/v1/organization/%s", instances.get(0).getUri().toString(), organizationId);

        ResponseEntity<Organization> restExchange =
                restTemplate.exchange(
                        serviceUri,
                        HttpMethod.GET,
                        null, Organization.class, organizationId);

        return restExchange.getBody();
    }
}
