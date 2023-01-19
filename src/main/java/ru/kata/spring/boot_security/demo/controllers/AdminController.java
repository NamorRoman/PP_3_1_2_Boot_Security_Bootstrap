package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.models.User;
import ru.kata.spring.boot_security.demo.services.RoleService;
import ru.kata.spring.boot_security.demo.services.UserService;


@Controller
public class AdminController {

    UserService userService;
    RoleService roleService;

    @Autowired
    public AdminController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/admin")
    public String boots(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        model.addAttribute("principal", user);
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.findAll());
        model.addAttribute("roles",roleService.findAll());
        return "bootstrap-admin";
    }


//    @GetMapping("admin/{id}/edit_user")
//    public String showUserById(@PathVariable("id") Long id, Model model) {
//        model.addAttribute("user", userService.getByID(id));
//        return "edit-user";
//    }

    @PatchMapping("admin/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.update(user);
        return "redirect:/admin";
    }

    @DeleteMapping("admin/{id}")
    public String deleteUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.delete(user);
        return "redirect:/admin";
    }

//    @GetMapping("admin/new_user")
//    public String newUser(@ModelAttribute("user") User user) {
//        return "new-user";
//    }

    @PostMapping("/admin/save_new_user")
    public String addUser(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/admin";
    }

}
