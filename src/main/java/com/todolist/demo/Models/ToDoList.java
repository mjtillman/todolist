package com.todolist.demo.Models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="todolists")
public class ToDoList {

  @Id @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String title;

  @Column
  private ArrayList<String> tasks;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private User owner;

  public ToDoList(long id, String title, List<String> tasks, User owner) {
    this.id = id;
    this.title = title;
    this.tasks = tasks;
    this.owner = owner;
  }

  public long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public List<String> getTasks() {
    return tasks;
  }

  public User getOwner() {
    return owner;
  }
}
