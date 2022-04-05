package com.example.PP_Spring_Boot_3_1_1.service;

import com.example.PP_Spring_Boot_3_1_1.model.User;

import java.util.List;

public interface UserService {
    List<User> userList();
    void saveUser(User user);
    void updateUser (User user);
    void delete(int id);
    User getById(int id);
}
