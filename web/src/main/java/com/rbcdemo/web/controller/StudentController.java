package com.rbcdemo.web.controller;

import com.rbcdemo.dao.entity.Student;
import com.rbcdemo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping(path = "/findAllStudent")
    public List<Student> findAllStudent(){
        return  studentService.selectAll();
    }

    @GetMapping(path = "/selectByPrimaryKey")
    public Student selectByPrimaryKey(int id){
        return  studentService.selectByPrimaryKey(id);
    }
}
