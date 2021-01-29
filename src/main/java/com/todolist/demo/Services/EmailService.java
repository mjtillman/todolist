package com.todolist.demo.Services;

import com.todolist.demo.Models.ToDoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("mailService")
public class EmailService {

  @Autowired
  public JavaMailSender emailSender;

  @Value("${spring.mail.from}")
  private String from;

  public void prepareAndSend(ToDoList listPost, String title, String toDoList) {
    SimpleMailMessage msg = new SimpleMailMessage();
    msg.setFrom(from);
    msg.setTo(listPost.getOwner().getEmail());
    msg.setSubject(title);
    msg.setText(toDoList);

    try {
      this.emailSender.send(msg);
    } catch (MailException ex) {
      System.err.println(ex.getMessage());
    }
  }
}
