package com.join.GoodsTradingProgram.test;

import com.join.GoodsTradingProgram.controller.user.UserController;
import com.join.GoodsTradingProgram.entity.user.User;
//import org.junit.jupiter.api.Test;
import com.join.GoodsTradingProgram.service.userService.UserService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
public class UserTest {

    @Autowired
    UserService userService;

    @Test
    public void testlistUser()throws Exception{
        List list = new ArrayList();

    }

    @Test
    public void testLogin()throws Exception{
        User user = new User();
        user.setUsername("newUser");
        user.setPassword("123456");
        System.out.println(userService.login(user));
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
        System.out.println(userService.register(user));

    }

    @Test
    public void testDelUser()throws Exception{
        int id=2;
        System.out.println(userService.delUser(id));
    }

    @Test
    public void testUpdatePwd()throws Exception{
        User user = new User();
        user.setPassword("654321");
        System.out.println(userService.updatePwd(user));
    }

    @Test
    public void testUpdateIntro()throws Exception{
        User user = new User();
        user.setIntroduction("Hello world!");
        System.out.println(userService.updateIntro(user));
    }

    @Test
    public void testUpdateTel()throws Exception{
        User user = new User();
        user.setTelnum("12345678901");
        System.out.println(userService.updateTel(user));
    }

    @Test
    public void testUploadHead()throws Exception{
        User user = new User();
        user.setHeadurl("XXXXXX");
        System.out.println(userService.uploadHead(user));
    }
}