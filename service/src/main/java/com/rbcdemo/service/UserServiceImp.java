package com.rbcdemo.service;

import com.rbcdemo.dao.entity.User;
import com.rbcdemo.dao.mapper.UserMapper;
import com.rbcdemo.model.UserAddReq;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    @Transactional
    public void TransactionTest(UserAddReq req) {

        User user=new User(req.Id,req.UserName, req.password);
        userMapper.updateByPrimaryKey(user);

        int a=1/0;

        User user2=new User(4,"xx","manman");
        userMapper.insert(user2);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(User record) {
        return userMapper.insert(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<User> selectAll() {
        return userMapper.selectAll();
    }

    @Override
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }
}
