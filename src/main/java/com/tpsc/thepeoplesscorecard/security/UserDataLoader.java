package com.tpsc.thepeoplesscorecard.security;

import com.tpsc.thepeoplesscorecard.data.UserRepository;
import com.tpsc.thepeoplesscorecard.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class UserDataLoader implements CommandLineRunner {

    private final UserRepository userRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserDataLoader(UserRepository userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        User user = new User("nrbratt@neiu.edu", "NickB", passwordEncoder.encode("password"),
                "Nick", "Bratt");
        user.setRoles(Set.of(User.Role.ROLE_ADMIN));
        user.setEnabled(true);
        userRepo.save(user);
        */
    }
}
