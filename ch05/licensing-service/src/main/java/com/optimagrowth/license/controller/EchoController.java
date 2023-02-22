package com.optimagrowth.license.controller;

import com.optimagrowth.license.model.Echo;
import com.optimagrowth.license.service.EchoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/echo")
public class EchoController {

    private final EchoService echoService;

    public EchoController(EchoService echoService) {
        this.echoService = echoService;
    }


    @GetMapping("/{message}")
    public Echo echo(@PathVariable("message") String message) {
        log.info("echo message = {}", message);
        return echoService.echo(message);
    }
}
