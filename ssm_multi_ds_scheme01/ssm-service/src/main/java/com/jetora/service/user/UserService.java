package com.jetora.service.user;

import com.jetora.pojo.User;

import java.util.List;

public interface UserService {
    User getUserById(Integer userId);
    List<User> getAllUsers();
    int delUserById(Integer id);
    int insertUser(User record);
    int updateUserById(User record);
}
