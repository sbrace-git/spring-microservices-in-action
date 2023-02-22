package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Optional;
import java.util.Random;

@Service
public class LicenseService {

    private final MessageSource messageSource;

    public LicenseService(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public License getLicense(String licenseId, String organizationId) {
        return new License().setId(new Random().nextInt(1000))
                .setLicenseId(licenseId)
                .setOrganizationId(organizationId)
                .setDescription("Software product")
                .setProductName("Ostock")
                .setLicenseType("full");
    }


    public String createLicense(License license, String organizationId, Locale locale) {
        return Optional.ofNullable(license)
                .map(l -> l.setOrganizationId(organizationId))
                .map(l -> String.format(
                        messageSource.getMessage("license.create.message", null,
                                Optional.ofNullable(locale).orElseGet(LocaleContextHolder::getLocale)), l))
                .orElse(null);
    }

    public String updateLicense(License license, String organizationId) {
        return Optional.ofNullable(license)
                .map(l -> l.setOrganizationId(organizationId))
                .map(l -> String.format(messageSource.getMessage("license.update.message", null,
                        LocaleContextHolder.getLocale()), l))
                .orElse(null);
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);
    }
}
