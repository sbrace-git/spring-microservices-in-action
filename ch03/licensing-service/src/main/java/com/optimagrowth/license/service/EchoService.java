package com.optimagrowth.license.service;

import com.optimagrowth.license.model.Echo;
import org.springframework.stereotype.Service;

@Service
public class EchoService {

    public Echo echo(String message) {
        return new Echo().setMessage(message);
    }
}
