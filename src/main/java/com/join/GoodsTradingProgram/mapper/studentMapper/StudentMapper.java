package com.join.GoodsTradingProgram.mapper.studentMapper;

import com.join.GoodsTradingProgram.entity.student.Student;
import com.join.GoodsTradingProgram.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 11:10 2020/5/12
 */
@Mapper
@Repository
public interface StudentMapper {
    public List<Student> listStudent() throws Exception;
    public Student login(@Param("student")Student student) throws Exception;
    public boolean addStudent(@Param("student") Student student )throws Exception;
    public Student selectStumessage(@Param("student") Student student) throws Exception;
    public boolean delStudent(@Param("id")int id)throws Exception;
    public boolean updatePwd(@Param("student")Student student) throws Exception;
}
