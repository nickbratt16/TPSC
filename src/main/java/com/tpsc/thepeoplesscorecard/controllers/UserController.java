package com.tpsc.thepeoplesscorecard.controllers;

import com.tpsc.thepeoplesscorecard.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String showUserInfo(Model model) {
        model.addAttribute("user", new User());

        return "add_user";
    }

    @PostMapping
    public String handleUserForm(@ModelAttribute("user")User user, RedirectAttributes attributes) {
        attributes.addAttribute("fullName", user.getFirstName() + " " + user.getLastName());
        System.out.println("First name" + user.getFirstName());
        System.out.println("Last name" + user.getLastName());
        System.out.println("Email" + user.getEmail());
        return "redirect:/display";
    }
}
