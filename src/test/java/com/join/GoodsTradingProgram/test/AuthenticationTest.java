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

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        String idcardString = "";
        JSONObject res = userController.recognize(idcardString);
        System.out.print(res);
//        HashMap<String,String> data = userController.recognize(idcardString);
//        Set<String> set= data.keySet();
//        Iterator iterator=set.iterator();
//        while (iterator.hasNext()){
//            Object key=iterator.next();
//            System.out.print(key);
//            System.out.print(data.get(key));
//        }
    }
}
