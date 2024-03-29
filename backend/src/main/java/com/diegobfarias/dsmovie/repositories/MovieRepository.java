package com.diegobfarias.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.diegobfarias.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
