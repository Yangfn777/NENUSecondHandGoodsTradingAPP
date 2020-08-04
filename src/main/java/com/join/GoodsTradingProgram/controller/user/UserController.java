package com.join.GoodsTradingProgram.controller.user;

import com.join.GoodsTradingProgram.entity.user.User;
import com.join.GoodsTradingProgram.service.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @ResponseBody
    @RequestMapping(value = "/list")
    public List<User> listUser()throws Exception{
        return userService.listUser();
    }

    @ResponseBody
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

    @ResponseBody
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

    @ResponseBody
    @RequestMapping(value = "/delUser")
    public int delUser(int id)throws Exception{
        return userService.delUser(id);
    }

    @ResponseBody
    @RequestMapping(value = "/updateUser")
    public int updateUser(User user)throws Exception{
        return userService.updateUser(user);
    }
}
