package com.diegobfarias.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.diegobfarias.dsmovie.dto.MovieDTO;
import com.diegobfarias.dsmovie.dto.ScoreDTO;
import com.diegobfarias.dsmovie.entities.Movie;
import com.diegobfarias.dsmovie.entities.Score;
import com.diegobfarias.dsmovie.entities.User;
import com.diegobfarias.dsmovie.repositories.MovieRepository;
import com.diegobfarias.dsmovie.repositories.ScoreRepository;
import com.diegobfarias.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ScoreRepository scoreRepository;
	
	@Transactional
	public MovieDTO saveScore(ScoreDTO scoreDTO) {
		
		User user = userRepository.findByEmail(scoreDTO.getEmail());
		Movie movie = movieRepository.findById(scoreDTO.getMovieId()).get();
		
		if (user == null) {
			user = new User();
			user.setEmail(scoreDTO.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(scoreDTO.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sumOfScores = 0.0;
		for (Score s : movie.getScores()) {
			sumOfScores = sumOfScores + s.getValue();
		}
		
		double average = sumOfScores / movie.getScores().size();
		
		movie.setScore(average);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}
