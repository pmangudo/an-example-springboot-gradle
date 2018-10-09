package com.myspringboot.greeting;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class GroovyApp {

    @RequestMapping("/groovy")
    String home() {
        return "Hello World with groovy!";
    }

}
