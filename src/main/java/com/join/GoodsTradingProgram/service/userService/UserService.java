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
    public boolean register(User user) throws Exception;
    public User selectUserMessage(User user) throws Exception;
    public boolean delUser(int id)throws Exception;
    public boolean updatePwd(int id) throws Exception;
    public boolean updateIntro(int id)throws Exception;
    public boolean updateTel(int id)throws Exception;
    public boolean uploadHead(int id)throws Exception;
}
