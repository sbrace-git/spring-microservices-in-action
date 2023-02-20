package com.optimagrowth.license.model;


import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Echo {
    private String message;
}
