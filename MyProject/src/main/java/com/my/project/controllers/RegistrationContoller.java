package com.my.project.controllers;

import com.my.project.domains.Role;
import com.my.project.domains.User;
import com.my.project.repos.UserRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;

@Controller
public class RegistrationContoller {
    @Autowired
    private UserRepos userRepos;
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("message", "Registration form:");
        return "registration";
    }
    @PostMapping("/registration")
    public String addUser(User user, Model model) {
        User userFromDb = userRepos.findByUsername(user.getUsername());
        if(userFromDb!=null) {
            model.addAttribute("message","User exists");
            return "registration";
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepos.save(user);

        return "redirect:login";
    }
}
