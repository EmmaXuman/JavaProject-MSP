package com.rbcdemo.service;

import com.rbcdemo.dao.entity.Student;

import java.util.List;

public interface StudentService {
    /**
     * 通过主键删除
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增学员
     */
    int insert(Student record);

    /**
     * 通过主键查询
     */
    Student selectByPrimaryKey(Integer id);

    /**
     * 查询学员列表
     */
    List<Student> selectAll();

    /**
     * 通过主键更新
     */
    int updateByPrimaryKey(Student record);
}

