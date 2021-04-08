package com.tpsc.thepeoplesscorecard.controllers;

import com.tpsc.thepeoplesscorecard.data.ScoreRepository;
import com.tpsc.thepeoplesscorecard.models.Scores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

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

    @GetMapping("/view/{id}")
    public String showScore(@PathVariable Long id, Model model) {
        Scores scores = this.scoreRepo.findById(id).get();
        model.addAttribute("scores", scores);
        return "view_score";
    }

    @PostMapping
    public String handleScoreForm(@Valid @ModelAttribute("scores") Scores scores, Errors errors) {

        if (errors.hasErrors())
            return "score_sheet";

        this.scoreRepo.save(scores);

        return "redirect:/scoreDisplay";
    }

    @PostMapping("/edit/{id}")
    public String handleEditScoreForm(@PathVariable Long id, @Valid @ModelAttribute("scores") Scores scores, Errors errors) {

        if (errors.hasErrors())
            return "view_score";

        Scores originalScore = this.scoreRepo.findById(id).get();
        this.scoreRepo.save(scores);

        return "redirect:/scoreDisplay";
    }

    private void updateOriginalScore(Scores original, Scores update) {
        original.setFighter1(update.getFighter1());
        original.setFighter2(update.getFighter2());
        original.setRound1Score1(update.getRound1Score1());
        original.setRound1Score2(update.getRound1Score2());
        original.setRound2Score1(update.getRound2Score1());
        original.setRound2Score2(update.getRound2Score2());
        original.setRound3Score1(update.getRound3Score1());
        original.setRound3Score2(update.getRound3Score2());
        original.setTotal1(update.getTotal1());
        original.setTotal2(update.getTotal2());
    }
}
