package com.tpsc.thepeoplesscorecard.data;

import com.tpsc.thepeoplesscorecard.models.Scores;
import org.springframework.data.repository.CrudRepository;

public interface ScoreRepository extends CrudRepository<Scores, Long> {
}
