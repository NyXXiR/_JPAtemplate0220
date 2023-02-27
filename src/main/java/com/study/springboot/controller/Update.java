package com.study.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.study.springboot.entity.Movie;
import com.study.springboot.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2

@RequiredArgsConstructor
public class Update {
  final MovieRepository movieRepository;

  @GetMapping("/update/{mno}")
  public String update(@PathVariable long mno, Model model) {
    log.info("-----------------" + mno);

    Movie movie = this.movieRepository.findById(mno).orElseThrow();
    log.info("-----------------" + movie);

    model.addAttribute("movie", movie);
    return "view/update";
  }

}
