package com.rbcdemo.service.abstactions;

import com.rbcdemo.dao.entity.Menu;
import com.rbcdemo.dao.entity.Student;
import com.rbcdemo.dao.entity.User;
import com.rbcdemo.dao.mapper.UserMapper;
import com.rbcdemo.model.UserAddReq;

import java.util.List;

public interface UserService {
    /*测试事务*/
    void TransactionTest(UserAddReq req);

    /**
     * 通过主键删除
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新增用户记录
     */
    int insert(UserAddReq record);

    /**
     * 主键查询
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 查询
     */
    List<User> selectAll();

    /**
     * 主键更新
     */
    int updateByPrimaryKey(UserAddReq record);

    User findByUsername(User user);

    List<Menu> GetUserMenu(int userid);
}
