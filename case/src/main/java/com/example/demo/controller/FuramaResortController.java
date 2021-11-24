package com.example.demo.controller;

import com.example.demo.model.entity.security.User;
import com.example.demo.model.service.security.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class FuramaResortController {

    @GetMapping(value = {"/login"})
    public String getLoginPage() {
        return "login";
    }

    @GetMapping(value = {"", "/home"})
    public String welcomePage() {
        return "index";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }


    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private IUserService userService;

    @GetMapping("/user")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("user", new User());
        return modelAndView;
    }

    @PostMapping("/saveuser")
    public String save (@ModelAttribute User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userService.save(user);
        return "redirect:/login";
    }
}
