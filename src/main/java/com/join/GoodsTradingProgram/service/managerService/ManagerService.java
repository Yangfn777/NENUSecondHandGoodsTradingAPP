package com.join.GoodsTradingProgram.service.managerService;


import com.join.GoodsTradingProgram.entity.manager.Manager;
import com.join.GoodsTradingProgram.entity.user.User;

import java.util.List;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 16:36 2020/5/17
 */
public interface ManagerService {
    public Manager login(Manager manager)throws Exception;

    public boolean addManager(Manager manager)throws Exception;

    public boolean updateManager(Manager manager)throws Exception;

    public List<Manager> ListManager()throws Exception;
}
