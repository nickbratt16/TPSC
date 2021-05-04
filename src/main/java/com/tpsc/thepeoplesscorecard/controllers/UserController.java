package com.tpsc.thepeoplesscorecard.controllers;

import com.tpsc.thepeoplesscorecard.data.UserRepository;
import com.tpsc.thepeoplesscorecard.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.Set;
import java.util.List;

@Controller
@RequestMapping("/register")
public class UserController {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping
    public String showUser(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/view/{id}")
    public String showUser(@PathVariable Long id, Model model) {
        User user = this.userRepo.findById(id).get();
        model.addAttribute("user", user);
        return "view_user";
    }

    @PostMapping
    public String handleUserForm(@Valid @ModelAttribute("user") User user, Errors errors) {
        if (errors.hasErrors())
            return "register";

        User register = new User();

        register.setEmail(user.getEmail());
        register.setPassword(passwordEncoder.encode(user.getPassword()));
        register.setUsername(user.getUsername());
        register.setFirstName(user.getFirstName());
        register.setLastName(user.getLastName());

        register.setRoles(Set.of(User.Role.ROLE_USER));
        register.setEnabled(true);

        this.userRepo.save(register);

        return "redirect:/login";
    }

    @PostMapping("/edit/{id}")
    public String handleEditUserForm(@PathVariable Long id, @Valid @ModelAttribute("user") User user, Errors errors) {

        if (errors.hasErrors())
            return "view_user";

        User originalUser = this.userRepo.findById(id).get();
        updateOriginalUser(originalUser, user);
        this.userRepo.save(originalUser);

        return "redirect:/userDisplay";
    }

    private void updateOriginalUser(User original, User update) {
        original.setEmail(update.getEmail());
        original.setUsername(passwordEncoder.encode(update.getUsername()));
        original.setPassword(update.getPassword());
        original.setFirstName(update.getFirstName());
        original.setLastName(update.getLastName());
    }

}
