package com.clc.bop.kite;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KiteAppController {
    @GetMapping("/foo") String foo() {
        System.out.println("you called foo");
        return "you called foo";
    }
}
