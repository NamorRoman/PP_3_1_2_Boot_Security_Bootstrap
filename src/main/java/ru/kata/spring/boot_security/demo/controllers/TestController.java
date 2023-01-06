package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class TestController {


    @GetMapping("/index")
    public String indexPage() {
        return "index";
    }

    @GetMapping("/authen")
    public String pageForAuthen (Principal principal) {
        return principal.getName();
    }

    @GetMapping("/read")
    public String readPage() {
        return "read-page";
    }

    @GetMapping("/adminPage")
    public String adminPage() {
        return "admin-page";
    }
}
