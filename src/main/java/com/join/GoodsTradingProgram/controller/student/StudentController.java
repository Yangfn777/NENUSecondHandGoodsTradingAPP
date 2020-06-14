package com.join.GoodsTradingProgram.controller.student;

import com.join.GoodsTradingProgram.entity.student.Student;
import com.join.GoodsTradingProgram.service.studentService.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: Liuxj
 * @Description:
 * @Date: 11:20 2020/5/12
 */
@CrossOrigin
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "list")
    public List<Student> listStudent() throws Exception{
        List<Student> list = studentService.listStudent();
        return list;
    }

    @RequestMapping(value = "login")
    public int login(Student student)throws Exception{
        Student st = studentService.login(student);
        int a=1;
        if (st == null){
            a = 0;
            return a;
        }
        else{
            return a;
        }

    }

    @RequestMapping(value = "register")
    public int register(Student student) throws Exception{
        Student st = studentService.selectStumessage(student);
        int b=0;
        if(st!=null){
            boolean a = studentService.addStudent(student);
            if(a==true){
                b=1;
            }
        }
        return b;

    }

    @RequestMapping(value = "addStudent")
    public int addStudent(Student student)throws Exception{
        boolean a = studentService.addStudent(student);
        int b=0;
        if(a==true){
            b=1;
        }
        return b;
    }

    @RequestMapping(value = "delStudent")
    public int delStudent(int id)throws Exception{
        boolean a = studentService.delStudent(id);
        int b=0;
        if (a==true){
            b=1;
        }
        return b;
    }

    @RequestMapping(value = "updatePwd")
    public int updatePwd(Student student)throws Exception{
        boolean a= studentService.updatePwd(student);
        int b=0;
        if (a==true){
            b=1;
        }
        return b;
    }
}
