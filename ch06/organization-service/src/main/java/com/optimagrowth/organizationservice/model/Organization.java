package com.optimagrowth.organizationservice.model;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Organization {

    private String id;
    private String name;
    private String contactName;
    private String contactEmail;
    private String contactPhone;

}
