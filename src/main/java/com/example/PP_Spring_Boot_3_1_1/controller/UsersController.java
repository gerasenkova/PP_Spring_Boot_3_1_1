package com.example.PP_Spring_Boot_3_1_1.controller;

import com.example.PP_Spring_Boot_3_1_1.model.User;
import com.example.PP_Spring_Boot_3_1_1.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    public UsersController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping()
    public String allUsers(Model model) {
        model.addAttribute("users", userService.userList());
        return "/index";
    }

    @GetMapping("/{id}")
    public String user(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "/show";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "/edit";
    }


    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }


    @DeleteMapping("/{id}")
    public String delete(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
