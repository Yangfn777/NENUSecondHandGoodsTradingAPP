package com.join.GoodsTradingProgram.service.studentService.impl;

import com.join.GoodsTradingProgram.entity.student.Student;
import com.join.GoodsTradingProgram.mapper.studentMapper.StudentMapper;
import com.join.GoodsTradingProgram.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 11:18 2020/5/12
 */
@Service
public class StudenServiceImpl implements StudentService {

    @Autowired
    StudentMapper studentMapper;

    @Override
    public List<Student> listStudent() throws Exception{
        List<Student> list = studentMapper.listStudent();
        return list;
    }

    @Override
    public Student login(Student student) throws Exception{
        Student a = studentMapper.login(student);
        return a;
    }

    @Override
    public boolean addStudent(Student student) throws Exception{
        boolean a = studentMapper.addStudent(student);
        return a;
    }

    @Override
    public Student selectStumessage(Student student) throws Exception{
        Student st = studentMapper.selectStumessage(student);
        return st;
    }

    @Override
    public boolean delStudent(int id) throws Exception{
        boolean a = studentMapper.delStudent(id);
        return a;
    }

    @Override
    public boolean updatePwd(Student student)throws Exception{
        boolean a = studentMapper.updatePwd(student);
        return a;
    }

}
