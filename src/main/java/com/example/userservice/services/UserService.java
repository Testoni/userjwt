package com.example.userservice.services;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;

import java.util.List;

public interface UserService {

    User save(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();

}
