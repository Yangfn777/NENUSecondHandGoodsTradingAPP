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
    public Integer register(User user) throws Exception;
    public User selectUserMessage(User user) throws Exception;
    public Integer delUser(int id)throws Exception;
    public Integer updatePwd(User user) throws Exception;
    public Integer updateIntro(User user)throws Exception;
    public Integer updateTel(User user)throws Exception;
    public Integer uploadHead(User user)throws Exception;
}
