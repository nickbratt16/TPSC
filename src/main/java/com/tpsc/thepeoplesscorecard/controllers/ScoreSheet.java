package com.tpsc.thepeoplesscorecard.controllers;

import com.tpsc.thepeoplesscorecard.models.Scores;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/scores")
public class ScoreSheet {

    @GetMapping
    public String showScores(Model model) {
        model.addAttribute("scores", new Scores());

        return "score_sheet";
    }

    @PostMapping
    public String handleScoreForm(@ModelAttribute ("scores") Scores scores, RedirectAttributes attributes) {
        attributes.addAttribute("finalScore", scores.getFighter1() + ": " +scores.getTotal1() + " " + scores.getFighter2() + ": " + scores.getTotal2());
        System.out.println("Fighter One Round One: " + scores.getRound1Score1());
        System.out.println("Fighter Two Round One: " + scores.getRound1Score2());
        System.out.println("Fighter One Round Two: " + scores.getRound2Score1());
        System.out.println("Fighter Two Round Two: " + scores.getRound2Score2());
        System.out.println("Fighter One Round Three: " + scores.getRound3Score1());
        System.out.println("Fighter Two Round Three: " + scores.getRound3Score2());

        return "redirect:/scoreDisplay";
    }

}
