package com.tpsc.thepeoplesscorecard.controllers;

import com.tpsc.thepeoplesscorecard.data.FightRepository;
import com.tpsc.thepeoplesscorecard.models.Fight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/fights")
public class FightController {

    private FightRepository fightRepo;

    @Autowired
    public FightController(FightRepository fightRepo) {

        this.fightRepo = fightRepo;
    }

    @GetMapping("/view")
    public String showFights(Model model) {
        List<Fight> fights = (List<Fight>) this.fightRepo.findAll();
        model.addAttribute("fights", fights);
        return "display_fights";
    }
}
