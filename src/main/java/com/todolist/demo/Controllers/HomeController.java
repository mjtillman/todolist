package com.todolist.demo.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

  @GetMapping("/")
  @ReponseBody
  public String greeting() {
    return "This is the landing page!";
  }
}
