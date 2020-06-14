package com.join.GoodsTradingProgram.test;

import com.join.GoodsTradingProgram.controller.manager.ManagerController;
import com.join.GoodsTradingProgram.entity.manager.Manager;
import com.join.GoodsTradingProgram.service.managerService.ManagerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 23:10 2020/5/23
 */
@SpringBootTest
public class ManagerTest {

    @Autowired
    ManagerController managerController;

    @Test
    public void ListAllTest()throws Exception{

    }

    @Test
    public void testLogin() throws Exception {
        Manager manager = new Manager();
        manager.setManagerName("manager1");
        manager.setPassword("123456");
        System.out.println(managerController.login(manager));
    }

    @Test
    public void testAddManager()throws Exception{
        Manager manager = new Manager();
        manager.setManagerName("newManager");
        manager.setPassword("123");
        System.out.println(managerController.addManager(manager));
    }
}
