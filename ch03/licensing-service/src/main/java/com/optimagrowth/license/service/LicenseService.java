package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class LicenseService {
    public License getLicense(String licenseId, String organizationId) {
        return new License().setId(new Random().nextInt(1000))
                .setLicenseId(licenseId)
                .setOrganizationId(organizationId)
                .setDescription("Software product")
                .setProductName("Ostock")
                .setLicenseType("full");
    }


    public String createLicense(License license, String organizationId) {
        return Optional.ofNullable(license)
                .map(l -> l.setOrganizationId(organizationId))
                .map(l -> String.format("This is the post and the object is: %s", l))
                .orElse(null);
    }

    public String updateLicense(License license, String organizationId) {
        return Optional.ofNullable(license)
                .map(l -> l.setOrganizationId(organizationId))
                .map(l -> String.format("This is the put and the object is: %s", l))
                .orElse(null);
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);
    }
}
