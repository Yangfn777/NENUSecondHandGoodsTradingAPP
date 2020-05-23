package com.join.GoodsTradingProgram.service.managerService.impl;

import com.join.GoodsTradingProgram.entity.manager.Manager;
import com.join.GoodsTradingProgram.entity.user.User;
import com.join.GoodsTradingProgram.mapper.managerMapper.ManagerMapper;
import com.join.GoodsTradingProgram.service.managerService.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 20:26 2020/5/17
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    ManagerMapper managerMapper;


    /**
     * 管理员登录
     * @param manager
     * @return
     * @throws Exception
     */
    @Override
    public Manager login(Manager manager) throws Exception {
        return null;
    }

    /**
     * 增加管理员
     * @param manager
     * @return
     * @throws Exception
     */
    @Override
    public Manager addManager(Manager manager) throws Exception {
        return null;
    }

    /**
     * 修改管理员个人信息
     * @param managerName
     * @param password
     * @return
     * @throws Exception
     */
    @Override
    public Manager updateManager(String managerName, String password) throws Exception {
        return null;
    }

    /**
     * 查询管理员列表
     * @return
     * @throws Exception
     */
    @Override
    public List<Manager> ListManager() throws Exception {
        return null;
    }

    /**
     * 查询用户列表
     * @return
     * @throws Exception
     */
    @Override
    public List<User> ListUser() throws Exception {
        return null;
    }

    /**
     * 删除用户
     * @param user
     * @return
     * @throws Exception
     */
    @Override
    public User deleteUser(User user) throws Exception {
        return null;
    }
}
