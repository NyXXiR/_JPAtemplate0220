package com.study.springboot.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.springboot.entity.Movie;
import com.study.springboot.repository.MovieRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/view/*")
public class Update {
	MovieRepository movieRepository;
	
	@GetMapping("/update")
	public void update(long mno, Model model) {
		Optional<Movie> movie = movieRepository.findById(mno);
		model.addAttribute("movie",movie);
	}
	
	@PostMapping("/update")
	public String upload(Movie movie) {
		movieRepository.save(movie);
		return "redirect:/view/list";
	}
}
