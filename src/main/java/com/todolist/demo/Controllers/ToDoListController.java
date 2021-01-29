package com.todolist.demo.Controllers;

import com.todolist.demo.Models.ToDoList;
import com.todolist.demo.Models.ToDoListRepository;
import com.todolist.demo.Models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ToDoListController {

  private final ToDoListRepository toDoListRepo;
  private final Users userRepo;
  private EmailService emailService;

  public ToDoListController(ToDoListRepository toDoListRepo, Users userRepo, EmailService emailService) {
    this.toDoListRepo = toDoListRepo;
    this.userRepo = userRepo;
    this.emailService = emailService;
  }

  @GetMapping("/lists")
  public String viewPosts(Model model) {
    model.addAttribute("toDoLists", toDoListRepo.findAll());
    return "posts/show";
  }

  @GetMapping("/lists/{id}")
  public String viewListByID(@PathVariable Long id, Model model) {
    ToDoList toDoList = toDoListRepo.findOne(id);
    model.addAttribute("toDoList", toDoList);
    return "posts/show";
  }

  @GetMapping("/lists/{id}/edit")
  public String editList(@PathVariable Long id, Model model) {
    ToDoList toDoList = toDoListRepo.findOne(id);
    model.addAttribute("toDoList", toDoList);
    return "posts/show";
  }

  @GetMapping("/lists/create")
  public String viewPostForm(Model model) {
    model.addAttribute("BlogPost", new BlogPost());
    return "posts/create";
  }

  @PostMapping("/lists/create")
  public String createPost(@ModelAttribute ToDoList newToDoList) {
    newToDoList.setOwner(userRepo.findOne(1L));
    toDoListRepo.save(newToDoList);
    emailService.prepareAndSend(newPost, "Post has been created", "Post has been created successfully and you can find it with the ID of " + newToDoList.getId());
    return "posts/show";
  }
}