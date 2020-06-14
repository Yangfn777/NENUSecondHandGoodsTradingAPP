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
 * @Author: Yangfn
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
    @RequestMapping("/listAll")
    public List<User> listAll()throws Exception{
        return userService.listAll();
    }
}
