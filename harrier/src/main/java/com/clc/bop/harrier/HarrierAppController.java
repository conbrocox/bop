package com.clc.bop.harrier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HarrierAppController {
    @Value("${um.ok}")
    private String greeting;

    @Value("${msg}")
    private String somethingElse;

    @GetMapping("/greeting")
    public String getGreeting() {
        return greeting;
    }

    @GetMapping("/somethingElse")
    public String getSomethingElse() {
        return somethingElse;
    }
}
