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

    @ResponseBody
    @RequestMapping(value = "/listManager")
    public List<Manager> ListManager()throws Exception{
        return managerService.ListManager();
    }

    @ResponseBody
    @RequestMapping(value = "/login")
    public int login(Manager manager)throws Exception{
        Manager manager1 = managerService.login(manager);
        int a=1;
        if (manager1 == null){
            a=0;
            return a;//无此用户
        }
        else {
            return a;//有此用户
        }
    }

    @ResponseBody
    @RequestMapping(value = "/addManager")
    public int addManager(Manager manager)throws Exception{
        return managerService.addManager(manager);
    }

    @ResponseBody
    @RequestMapping(value = "/updateManager")
    public int updateManager(Manager manager)throws Exception{
        return managerService.updateManager(manager);
    }
}
