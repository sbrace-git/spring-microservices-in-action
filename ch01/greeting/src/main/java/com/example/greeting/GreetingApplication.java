package com.example.greeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
@RequestMapping("hello")
public class GreetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(GreetingApplication.class, args);
    }

    @GetMapping(value = "/{firstName}")
    public String helloGet(@PathVariable("firstName") String firstName,
                           @RequestParam("lastName") String lastName) {
        return String.format("{\"message\":\"Hello %s %s\"}", firstName, lastName);
    }

    @PostMapping
    public String helloPost(@RequestBody HelloRequest request) {
        return String.format("{\"message\":\"Hello %s %s\"}", request.getFirstName(), request.getLastName());
    }
}


class HelloRequest {
    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
