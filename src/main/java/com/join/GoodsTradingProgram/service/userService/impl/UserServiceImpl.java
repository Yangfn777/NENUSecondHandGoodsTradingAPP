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
        return userMapper.listUser();
    }

    @Override
    public User login(User user) throws Exception {
        return userMapper.login(user);
    }

    @Override
    public int register(User user) throws Exception {
        return userMapper.register(user);
    }

    @Override
    public User selectUserMessage(User user) throws Exception {
        return userMapper.selectUserMessage(user);
    }

    @Override
    public int delUser(int id) throws Exception {
        return userMapper.delUser(id);
    }

    @Override
    public int updateUser(User user) throws Exception {
        return userMapper.updateUser(user);
    }


}
