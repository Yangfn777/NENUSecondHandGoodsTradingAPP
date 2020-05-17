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
        return null;
    }

    /**
     * 管理员列表
     * @return
     * @throws Exception
     */
    @Override
    public List<Manager> ListAll() throws Exception {
        return null;
    }
}
