package com.my.project.controllers;

import com.my.project.domains.Message;
import com.my.project.domains.User;
import com.my.project.repos.MessageRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("main")
public class MainController {
    @Autowired
    private MessageRepos messageRepos;

    @GetMapping
    public String helloReturn(@RequestParam(name = "filter", required = false) String filter, Model model) {
        Iterable<Message> messages;
        if(filter==null || filter.isEmpty()) {
            messages = messageRepos.findAll();
        }
        else {
            messages = messageRepos.findByTag(filter);
        }
        model.addAttribute("messages", messages);
        return "main";
    }
    @PostMapping
    public String addMessage(@AuthenticationPrincipal User user, @RequestParam String text, @RequestParam String tag) {
        Message message = new Message(text, tag,user);
        messageRepos.save(message);
        return "redirect:main";
    }



}
