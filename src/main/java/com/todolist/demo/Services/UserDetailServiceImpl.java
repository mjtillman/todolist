package com.todolist.demo.Services;

import com.todolist.demo.Models.User;
import com.todolist.demo.Models.UserWithRoles;
import com.todolist.demo.Models.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
  private final Users users;

  public UserDetailServiceImpl(Users users) {
    this.users = users;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = users.findByUsername(username);
    if (user == null) {
      throw new UsernameNotFoundException("No user found for " + username);
    }

    return new UserWithRoles(user);
  }
}
