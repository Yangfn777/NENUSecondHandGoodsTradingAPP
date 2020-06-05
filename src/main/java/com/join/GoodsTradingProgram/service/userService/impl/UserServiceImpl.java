package com.join.GoodsTradingProgram.service.userService.impl;

import com.join.GoodsTradingProgram.entity.user.User;
import com.join.GoodsTradingProgram.mapper.userMapper.UserMapper;
import com.join.GoodsTradingProgram.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 22:21 2020/5/9
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public List<User> listUser() throws Exception {
        return null;
    }

    @Override
    public User login(User user) throws Exception {
        return null;
    }

    @Override
    public boolean addUser(User user) throws Exception {
        return false;
    }

    @Override
    public User selectUserMessage(User user) throws Exception {
        return null;
    }

    @Override
    public boolean delUser(int id) throws Exception {
        return false;
    }

    @Override
    public boolean updatePwd(User user) throws Exception {
        return false;
    }
}
