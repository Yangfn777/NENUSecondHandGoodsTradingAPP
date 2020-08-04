package com.join.GoodsTradingProgram.service.managerService;


import com.join.GoodsTradingProgram.entity.manager.Manager;

import java.util.List;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 16:36 2020/5/17
 */
public interface ManagerService {
    public Manager login(Manager manager)throws Exception;

    public Integer addManager(Manager manager)throws Exception;

    public Integer updateManager(Manager manager)throws Exception;

    public List<Manager> ListManager()throws Exception;
}
