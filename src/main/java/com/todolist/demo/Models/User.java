package com.todolist.demo.Models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
public class User {
  @Id @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  private String username;

  @Column(nullable = false)
  private String password;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "owner")
  private List<ToDoList> toDoLists;

  public User(long id, String email, String username, String password, List<ToDoList> toDoLists) {
    this.id = id;
    this.email = email;
    this.username = username;
    this.password = password;
    this.toDoLists = toDoLists;
  }

  public User(User copy) {
    id = copy.id;
    email = copy.email;
    username = copy.username;
    password = copy.password;
    toDoLists = copy.toDoLists;
  }

  public long getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getUsername() {
    return username;
  }

  public List<ToDoList> getToDoLists() {
    return toDoLists;
  }
}
