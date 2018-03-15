package com.jetora.service.user.impl;

import com.jetora.dao.user.UserMapper;
import com.jetora.pojo.User;
import com.jetora.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int delUserById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
    @Override
    public int insertUser(User record) {
        return userMapper.insert(record);
    }
    @Override
    public  List<User> getAllUsers() {
        return userMapper.selectAll();
    }
    @Override
    public int updateUserById(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
}
