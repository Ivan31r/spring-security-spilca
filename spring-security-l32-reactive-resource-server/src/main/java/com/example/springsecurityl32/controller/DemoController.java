package com.example.springsecurityl32.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public Mono<String> demo() {
        return Mono.just("Demo");
    }
}
