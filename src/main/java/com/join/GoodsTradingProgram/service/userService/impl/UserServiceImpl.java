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
    public boolean register(User user) throws Exception {
        boolean a = userMapper.register(user);
        return a;
    }

    @Override
    public User selectUserMessage(User user) throws Exception {
        User u1 = userMapper.selectUserMessage(user);
        return u1;
    }

    @Override
    public boolean delUser(int id) throws Exception {
        boolean a = userMapper.delUser(id);
        return a;
    }

    @Override
    public boolean updatePwd(int id) throws Exception {
        boolean a = userMapper.updatePwd(id);
        return a;
    }

    @Override
    public boolean updateIntro(int id) throws Exception {
        boolean a = userMapper.updateIntro(id);
        return a;
    }

    @Override
    public boolean updateTel(int id) throws Exception {
        boolean a = userMapper.updateTel(id);
        return a;
    }

    @Override
    public boolean uploadHead(int id) throws Exception {
        boolean a = userMapper.uploadHead(id);
        return a;
    }
}
