package com.todolist.demo.Models;

import org.springframework.data.repository.CrudRepository;

public interface ToDoListRepository extends CrudRepository<ToDoList, Long> {
  ToDoList findToDoListById(Long id);
}

