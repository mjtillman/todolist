package com.todolist.demo.Controllers;

import com.todolist.demo.Models.Users;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class UserController {

  private Users users;
  private PasswordEncoder passwordEncoder;

  public UserController(Users users, PasswordEncoder passwordEncoder) {
    this.users = users;
    this.passwordEncoder = passwordEncoder;
  }

//  @GetMapping("/sign-up")
//  public String showSignupForm(Model model){
//    model.addAttribute("user", new User());
//    return "users/sign-up";
//  }

//  @PostMapping("/sign-up")
//  public String saveUser(@ModelAttribute User user) {
//    String hash = passwordEncoder.encode(user.getPassword());
//    user.setPassword(hash);
//    users.save(user);
//    return "redirect:/login";
//  }
}