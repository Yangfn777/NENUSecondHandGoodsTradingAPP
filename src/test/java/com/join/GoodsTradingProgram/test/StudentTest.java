package com.join.GoodsTradingProgram.test;

import com.join.GoodsTradingProgram.entity.student.Student;
import com.join.GoodsTradingProgram.service.studentService.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 19:52 2020/5/12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentTest {

    @Autowired
    StudentService studentService;

    @Test
    public void testLogin() throws Exception{
        Student student = new Student();
        student.setUsername("aa");
        student.setPassword("123");
        System.out.println(studentService.login(student));
    }

    @Test
    public void  testAdd() throws Exception{
        Student student = new Student();
        student.setPassword("testli");
        student.setUsername("testlii");
        student.setRealname("yfn");
        student.setStuno("123");
        student.setProfession("aa");
        System.out.println(studentService.addStudent(student));
    }


}
