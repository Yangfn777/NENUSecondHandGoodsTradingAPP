package com.join.GoodsTradingProgram.service.studentService;

import com.join.GoodsTradingProgram.entity.student.Student;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 11:18 2020/5/12
 */
public interface StudentService {
    public List<Student> listStudent() throws Exception;
    public Student login(Student student) throws Exception;
    public boolean addStudent(Student student)throws Exception;
    public Student selectStumessage(Student student) throws Exception;
    public boolean delStudent(int id)throws Exception;
    public boolean updatePwd(Student student) throws Exception;
}
