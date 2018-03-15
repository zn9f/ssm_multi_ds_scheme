package com.jetora.dao.user;

import com.jetora.pojo.User;
import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Integer uId);

    int insert(User record);

    User selectByPrimaryKey(Integer uId);

    List<User> selectAll();

    int updateByPrimaryKey(User record);
}