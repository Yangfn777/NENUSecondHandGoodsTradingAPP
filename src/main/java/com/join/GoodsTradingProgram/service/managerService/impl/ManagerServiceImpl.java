package com.join.GoodsTradingProgram.service.managerService.impl;

import com.join.GoodsTradingProgram.entity.manager.Manager;
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
        return managerMapper.login(manager);
    }

    /**
     * 添加管理员
     * @param manager
     * @return
     * @throws Exception
     */
    @Override
    public int addManager(Manager manager) throws Exception {
        return managerMapper.addManager(manager);
    }

    /**
     * 修改管理员密码
     * @param manager
     * @return
     * @throws Exception
     */
    @Override
    public int updateManager(Manager manager) throws Exception {
        return managerMapper.updateManager(manager);
    }

    /**
     * 查看管理员列表
     * @return
     * @throws Exception
     */
    @Override
    public List<Manager> ListManager() throws Exception {
        return managerMapper.listManager();
    }
}
