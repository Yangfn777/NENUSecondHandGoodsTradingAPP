package com.join.GoodsTradingProgram.test;

import com.join.GoodsTradingProgram.controller.user.UserController;
import com.join.GoodsTradingProgram.entity.user.User;
//import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 22:55 2020/5/9
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserController userController;

    @Test
    public void testAddUser()throws Exception{
        User user = new User();
        user.setUsername("newUser");
        user.setRealname("Liulq");
        user.setPassword("123");
        user.setProfession("Math");
        user.setStuno("2018010281");
        user.setIntroduction("Hello everyone!");
        user.setTelnum("18081204998");
        user.setHeadurl("XXXXXX");
        System.out.println("测试成功"+userController.addUser(user));

    }

    @Test
    public void testLogin()throws Exception{
        User user = new User();
        user.setUsername("newUser");
        user.setPassword("123456");
        System.out.println(userController.login(user));
    }

    @Test
    public void testlistUser()throws Exception{
        List list = new ArrayList();

    }

    @Test
    public void testUpdatePwd()throws Exception{
        User user = new User();
        user.setPassword("654321");
        System.out.println(userController.updatePwd(user));
    }

    @Test
    public void testUpdateIntro()throws Exception{
        User user = new User();
        user.setIntroduction("Hello world!");
        System.out.println(userController.updateIntro(user));
    }

    public void testDelUser()throws Exception{
        int id=5;
        System.out.println(userController.delUser(id));
    }
}