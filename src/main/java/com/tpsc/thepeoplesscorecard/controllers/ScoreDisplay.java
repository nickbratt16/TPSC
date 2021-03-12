package com.tpsc.thepeoplesscorecard.controllers;

import com.tpsc.thepeoplesscorecard.data.ScoreRepository;
import com.tpsc.thepeoplesscorecard.models.Scores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/scoreDisplay")
public class ScoreDisplay {

    private ScoreRepository scoreRepo;

    @Autowired
    public ScoreDisplay(ScoreRepository scoreRepo) {
        this.scoreRepo = scoreRepo;
    }

    @GetMapping
    public String displayScore(Model model) {
        List<Scores> scores = (List<Scores>) this.scoreRepo.findAll();
        model.addAttribute("scores", scores);
        return "final_score";
    }
}
