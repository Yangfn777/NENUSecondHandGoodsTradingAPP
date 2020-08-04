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
        List<User> list = userMapper.listUser();
        return list;
    }

    @Override
    public User login(User user) throws Exception {
        User a = userMapper.login(user);
        return a;
    }

    @Override
    public Integer register(User user) throws Exception {
        Integer a = userMapper.register(user);
        return a;
    }

    @Override
    public User selectUserMessage(User user) throws Exception {
        User u1 = userMapper.selectUserMessage(user);
        return u1;
    }

    @Override
    public Integer delUser(int id) throws Exception {
        Integer a = userMapper.delUser(id);
        return a;
    }

    @Override
    public Integer updatePwd(User user) throws Exception {
        Integer a = userMapper.updatePwd(user);
        return a;
    }

    @Override
    public Integer updateIntro(User user) throws Exception {
        Integer a = userMapper.updateIntro(user);
        return a;
    }

    @Override
    public Integer updateTel(User user) throws Exception {
        Integer a = userMapper.updateTel(user);
        return a;
    }

    @Override
    public Integer uploadHead(User user) throws Exception {
        Integer a = userMapper.uploadHead(user);
        return a;
    }
}
