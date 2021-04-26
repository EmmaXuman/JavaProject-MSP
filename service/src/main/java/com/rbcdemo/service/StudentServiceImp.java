package com.rbcdemo.service;

import com.google.gson.Gson;
import com.rbcdemo.common.RedisService;
import com.rbcdemo.dao.entity.Student;
import com.rbcdemo.dao.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private RedisService redisService;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return studentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Student record) {
        return studentMapper.insert(record);
    }

    @Override
    public Student selectByPrimaryKey(Integer id) {
        String key = "Student_" + id;
        Student student=(Student)redisService.get(key);
//        Student student = new Gson().fromJson((Student)rStr, Student.class);
        if (student != null) {
            return student;
        } else {
            Student curS = studentMapper.selectByPrimaryKey(id);
            String str = new Gson().toJson(curS);
            redisService.set(key, str);
            return curS;
        }
    }

    @Override
    public List<Student> selectAll() {
        return studentMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(Student record) {
        return studentMapper.updateByPrimaryKey(record);
    }
}
