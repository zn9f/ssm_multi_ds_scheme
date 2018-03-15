package com.jetora.dao.user;

import com.jetora.common.aspect.DataSource;
import com.jetora.pojo.User;
import java.util.List;

import static com.jetora.common.aspect.DynamicDataSourceGlobal.*;

public interface UserMapper {
    @DataSource(WRITE)
    int deleteByPrimaryKey(Integer uId);
    @DataSource(WRITE)
    int insert(User record);
    @DataSource(READ)
    User selectByPrimaryKey(Integer uId);
    @DataSource(READ)
    List<User> selectAll();
    @DataSource(WRITE)
    int updateByPrimaryKey(User record);
}