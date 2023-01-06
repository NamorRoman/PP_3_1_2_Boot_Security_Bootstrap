package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


    @GetMapping("/user")
    public String userPage() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "user";
    }

    @GetMapping("/read")
    public String readPage() {
        return "read-page";
    }

    @GetMapping("/admin")
    public String adminPage() {
        return "admin-page";
    }
}
