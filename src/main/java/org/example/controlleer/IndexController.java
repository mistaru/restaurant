package org.example.controlleer;

import org.springframework.web.bind.annotation.GetMapping;

public class IndexController {
    @GetMapping("/")
    public String hello(){
        return "index";
    }

}
