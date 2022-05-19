package com.diegobfarias.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegobfarias.dsmovie.entities.Score;
import com.diegobfarias.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK> {

}
