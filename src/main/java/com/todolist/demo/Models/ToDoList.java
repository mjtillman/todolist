package com.todolist.demo.Models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="todolists")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ToDoList {

  @Id @GeneratedValue
  private long id;

  @Column(nullable = false)
  private String title;

  @Column
  private List<String> tasks;

  @ManyToOne
  @JoinColumn(name = "owner_id")
  private User owner;
}
