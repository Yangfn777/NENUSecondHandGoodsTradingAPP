package com.join.GoodsTradingProgram.service.userService;

import com.join.GoodsTradingProgram.entity.user.User;
import java.util.List;


/**
 * @Author: Liulq
 * @Description:
 * @Date: 22:21 2020/5/9
 */
public interface UserService {
    public List<User> listUser() throws Exception;
    public User login(User user) throws Exception;
    public int register(User user) throws Exception;
    public User selectUserMessage(User user) throws Exception;
    public int delUser(int id)throws Exception;
    public int updateUser(User user) throws Exception;
    public int uploadHead(int id,String url) throws Exception;
}
