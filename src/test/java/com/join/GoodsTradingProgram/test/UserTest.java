package com.join.GoodsTradingProgram.test;

import com.join.GoodsTradingProgram.entity.user.User;
import com.join.GoodsTradingProgram.service.userService.UserService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
    UserService userService;

    @Test
    public void testlistUser()throws Exception{


    }

    @Test
    public void testLogin()throws Exception{
        User user = new User();
        user.setUsername("login");
        user.setPassword("123456");
        System.out.println(userService.login(user));
    }

    @Test
    public void testAddUser()throws Exception{
        User user = new User();
        user.setUsername("newUser");
        user.setRealname("Liulq");
        user.setPassword("123");
        user.setProfession("Math");
        user.setStuno("2018010281");
    }

}
