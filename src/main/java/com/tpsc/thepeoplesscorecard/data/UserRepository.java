package com.tpsc.thepeoplesscorecard.data;

import com.tpsc.thepeoplesscorecard.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

    User findByEmail(String email);
}
