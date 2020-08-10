package com.join.GoodsTradingProgram.test;

import com.join.GoodsTradingProgram.controller.user.UserController;
import com.join.GoodsTradingProgram.entity.user.User;
import com.join.GoodsTradingProgram.utils.Idcard.IdcardUtils;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Controller;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 11:55 2020/8/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Rollback(value = false)
@Controller
public class AuthenticationTest {

    @Autowired
    UserController userController;

    @Test
    public void testRecognize()throws Exception{
        User user = new User();
        user.setId(1);
        user.setFileurl("C:\\Users\\11250\\Pictures\\项目用\\学生卡.jpeg");
        JSONObject res = userController.recognize(user);
        System.out.println(res.toString(2));
    }
}
