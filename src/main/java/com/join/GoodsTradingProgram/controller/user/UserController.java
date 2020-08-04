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

    @RequestMapping(value = "list")
    public List<User> listUser()throws Exception{
        List<User> list = userService.listUser();
        return list;
    }

    @RequestMapping(value = "login")
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

    @RequestMapping(value = "register")
    public int register(User user)throws Exception{
        User user1 = userService.selectUserMessage(user);
        int b=0;
        if (user1 == null){
            boolean a = userService.register(user);
            if (a == true){
                b=1;
            }
        }
        return b;
    }

    @RequestMapping(value = "delUser")
    public int delUser(int id)throws Exception{
        boolean a = userService.delUser(id);
        int b=0;
        if (a == true){
            b=1;
        }
        return b;
    }

    @RequestMapping(value = "updatePwd")
    public int updatePwd(int id)throws Exception{
        boolean a = userService.updatePwd(id);
        int b=0;
        if (a == true){
            b=1;
        }
        return b;
    }

    @RequestMapping(value = "updateIntro")
    public int updateIntro(int id)throws Exception{
        boolean a = userService.updateIntro(id);
        int b = 0;
        if (a == true){
            b=1;
        }
        return b;
    }

    @RequestMapping(value = "updateTel")
    public int updateTel(int id)throws Exception{
        boolean a = userService.updateTel(id);
        int b=0;
        if (a == true){
            b=1;
        }
        return b;
    }

    @RequestMapping(value = "uploadHead")
    public int uploadHead(int id)throws Exception{
        boolean a = userService.uploadHead(id);
        int b=0;
        if (a == true){
            b=1;
        }
        return b;
    }
}
