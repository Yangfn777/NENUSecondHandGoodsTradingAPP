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
    public boolean addUser(User user)throws Exception;
    public User selectUserMessage(User user) throws Exception;
    public boolean delUser(int id)throws Exception;
    public boolean updatePwd(User user) throws Exception;
    public boolean updateIntro(User user)throws Exception;
    public boolean updateTel(User user)throws Exception;
    public boolean uploadHead(User user)throws Exception;
}
