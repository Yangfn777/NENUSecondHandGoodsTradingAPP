package com.join.GoodsTradingProgram.controller.user;

import com.join.GoodsTradingProgram.entity.user.User;
import com.join.GoodsTradingProgram.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 21:40 2020/5/9
 */
@Controller
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list")
    public List<User> listUser()throws Exception{
        return userService.listUser();
    }

    @RequestMapping(value = "/login")
    public int login(User user)throws Exception{
        User user1 = userService.login(user);
        int a=1;
        if (user1 == null){
            a=0;
            return a;
        }
        else {
            return a;
        }
    }

    @RequestMapping(value = "/register")
    public int register(User user)throws Exception{
        User user1 = userService.selectUserMessage(user);
        int b=0;
        if (user1 == null){
            Integer a = userService.register(user);
            if (a == 1){
                b=1;
            }
        }
        return b;
    }

    @RequestMapping(value = "/delUser")
    public Integer delUser(int id)throws Exception{
        Integer a = userService.delUser(id);
        return a;
    }

    @RequestMapping(value = "/updatePwd")
    public Integer updatePwd(User user)throws Exception{
        Integer a = userService.updatePwd(user);
        return a;
    }

    @RequestMapping(value = "updateIntro")
    public Integer updateIntro(User user)throws Exception{
        Integer a = userService.updateIntro(user);
        return a;
    }

    @RequestMapping(value = "updateTel")
    public Integer updateTel(User user)throws Exception{
        Integer a = userService.updateTel(user);
        return a;
    }

    @RequestMapping(value = "uploadHead")
    public Integer uploadHead(User user)throws Exception{
        Integer a = userService.uploadHead(user);
        return a;
    }
}
