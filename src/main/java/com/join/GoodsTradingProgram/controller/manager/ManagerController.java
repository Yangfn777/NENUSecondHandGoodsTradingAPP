package com.join.GoodsTradingProgram.controller.manager;

import com.join.GoodsTradingProgram.entity.manager.Manager;
import com.join.GoodsTradingProgram.entity.user.User;
import com.join.GoodsTradingProgram.service.managerService.ManagerService;
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
 * @Date: 15:22 2020/5/17
 */
@Controller
@RequestMapping("/manager")
@CrossOrigin
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    private UserService userService;

    @ResponseBody
    @RequestMapping("/listManager")
    public List<Manager> ListManager()throws Exception{
        return managerService.ListManager();
    }

}
