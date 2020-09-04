package com.join.GoodsTradingProgram.test;

import com.join.GoodsTradingProgram.controller.user.UserController;
import com.join.GoodsTradingProgram.entity.user.User;
//import org.junit.jupiter.api.Test;
import com.join.GoodsTradingProgram.service.userService.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
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
@Rollback(value = false)
@Controller
public class UserTest {

    @Autowired
    UserController userController;

    @Test
    public void testlistUser()throws Exception{
        System.out.println(userController.listUser());
    }

    @Test
    public void testLogin()throws Exception{
        User user = new User();
        user.setStuno("011");
        user.setPassword("123456");
        System.out.println(userController.login(user));
    }

    @Test
    public void testRegister()throws Exception{
        User user = new User();
        user.setRealname("llq");
        user.setUsername("user");
        user.setPassword("123456");
        user.setProfession("软件");
        user.setStuno("123454321");
        //user.setIntroduction("Hello everyone!");
        user.setTelnum("18981312998");
        //user.setHeadurl("XXXXXX");
        System.out.println(userController.register(user));

    }

    @Test
    public void testDelUser()throws Exception{
        int id=2;
        System.out.println(userController.delUser(id));
    }

    @Test
    public void testUpdateUser()throws Exception{
        User user = new User();
        user.setId(12);
        user.setUsername("123456");
        user.setPassword("654321");
        user.setIntroduction("Hello world!");
        user.setTelnum("1234");
        System.out.println(userController.updateUser(user));
    }
}