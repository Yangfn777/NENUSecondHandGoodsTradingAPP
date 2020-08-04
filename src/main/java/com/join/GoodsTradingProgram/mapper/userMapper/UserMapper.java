package com.join.GoodsTradingProgram.mapper.userMapper;

import com.join.GoodsTradingProgram.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liulq
 * @Description:
 * @Date: 22:19 2020/5/9
 */
@Repository
@Mapper
public interface UserMapper {
    /**
     * 列出所有user
     * @return
     * @throws Exception
     */
    public List<User> listUser()throws Exception;

    /**
     * 登录
     * @param user
     * @return
     * @throws Exception
     */
    public User login(@Param("user")User user) throws Exception;

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    public int register(@Param("user")User user)throws Exception;

    /**
     * 查找user的信息
     * @param user
     * @return
     * @throws Exception
     */
    public User selectUserMessage(@Param("user")User user)throws Exception;

    /**
     * 按id删除该user
     * @param id
     * @return
     * @throws Exception
     */
    public int delUser(@Param("id")int id)throws Exception;

    /**
     * 按id修改该user信息
     * @param user
     * @return
     * @throws Exception
     */
    public int updateUser(@Param("user")User user)throws Exception;

//    /**
//     * 查询
//     * @return
//     * @throws Exception
//     */
//    public List<User> queryUser(@Param("card")String card)throws Exception;
//    /**
//     * 查询
//     * @return
//     * @throws Exception
//     */
//    public List<Report> queryReport(@Param("stu_id")int stu_id)throws Exception;

//    /**
//     * 上传头像
//     * @return
//     * @throws Exception
//     */
//    public int uploadHead(@Param("id")int id,@Param("path")String path,@Param("HeadUrl")String HeadUrl)throws Exception;
//    /**
//     * 增加反馈
//     * @param feelBack
//     * @return
//     * @throws Exception
//     */
//    public int addFeelBack(@Param("feelBack")FeelBack feelBack)throws Exception;
}
