package com.todolist.demo.Models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

}
