package com.study.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class Create {


  @GetMapping("/create")
  public String create() {
    return null;
  }

  @PostMapping("/create")
  public String create2() {

    return "list";
  }
}
