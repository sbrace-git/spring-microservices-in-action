package com.optimagrowth.license.service;

import com.optimagrowth.license.model.Echo;
import org.springframework.stereotype.Service;

@Service
public class EchoService {

    public Echo echo(String message) {
        Echo echo = new Echo();
        echo.setMessage(message);
        return echo;
    }
}
