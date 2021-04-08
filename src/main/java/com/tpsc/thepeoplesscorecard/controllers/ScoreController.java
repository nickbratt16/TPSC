package com.tpsc.thepeoplesscorecard.controllers;

import com.tpsc.thepeoplesscorecard.data.ScoreRepository;
import com.tpsc.thepeoplesscorecard.models.Scores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
        /*List<Scores> scores = (List<Scores>) this.scoreRepo.findAll();
        model.addAttribute("scores", scores);*/

        model.addAttribute("scores", new Scores());

        return "score_sheet";
    }

    @PostMapping
    public String handleScoreForm(@Valid @ModelAttribute ("scores") Scores scores, Errors errors) {
        if (errors.hasErrors())
            return "score_sheet";

        //try {

        this.scoreRepo.save(scores);

        //} catch (DataIntegrityViolationException e) {
            //errors.rejectValue();
        //}

        return "redirect:/scoreDisplay";
    }

}
