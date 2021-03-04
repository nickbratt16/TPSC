package com.tpsc.thepeoplesscorecard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/display")
public class UserDisplay {
    @GetMapping
    public String displayUser(@ModelAttribute("fullName") Object fAttribute, Model model) {
        model.addAttribute("fullName", fAttribute);
        return "user_display";
    }
}
