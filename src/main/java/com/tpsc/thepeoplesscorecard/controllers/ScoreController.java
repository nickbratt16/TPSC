package com.tpsc.thepeoplesscorecard.controllers;

import com.tpsc.thepeoplesscorecard.data.ScoreRepository;
import com.tpsc.thepeoplesscorecard.models.Scores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/scores")
public class ScoreController {

    private ScoreRepository scoreRepo;

    @Autowired
    public ScoreController(ScoreRepository scoreRepo) {
        this.scoreRepo = scoreRepo;
    }

    @GetMapping
    public String showScores(Model model) {
        model.addAttribute("scores", new Scores());

        return "score_sheet";
    }

    @PostMapping
    public String handleScoreForm(@Valid @ModelAttribute ("scores") Scores scores, Errors errors) {
        if (errors.hasErrors())
            return "score_sheet";

        this.scoreRepo.save(scores);

        return "redirect:/scoreDisplay";
    }

}
