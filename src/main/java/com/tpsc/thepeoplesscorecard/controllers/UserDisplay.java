package com.tpsc.thepeoplesscorecard.controllers;

import com.tpsc.thepeoplesscorecard.data.UserRepository;
import com.tpsc.thepeoplesscorecard.models.Scores;
import com.tpsc.thepeoplesscorecard.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/userDisplay")
public class UserDisplay implements UserDetailsService {

    private UserRepository userRepo;

    @Autowired
    public UserDisplay(UserRepository userRepo) {

        this.userRepo = userRepo;
    }

    @GetMapping
    public String displayUser(Model model) {
        List<User> user = (List<User>) this.userRepo.findAll();
        model.addAttribute("user", user);
        return "index";
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
