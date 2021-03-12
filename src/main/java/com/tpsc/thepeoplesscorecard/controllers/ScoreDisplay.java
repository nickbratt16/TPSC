package com.tpsc.thepeoplesscorecard.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/scoreDisplay")
public class ScoreDisplay {
    @GetMapping
    public String displayScore(@ModelAttribute("finalScore") Object sAttribute, Model model) {
        model.addAttribute("finalScore", sAttribute);
        return "final_score";
    }
}
