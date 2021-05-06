package com.rbcdemo.service.applications;

import com.rbcdemo.dao.entity.*;
import com.rbcdemo.dao.mapper.MenuMapper;
import com.rbcdemo.dao.mapper.RolemenuMapper;
import com.rbcdemo.dao.mapper.UserMapper;
import com.rbcdemo.dao.mapper.UserroleMapper;
import com.rbcdemo.model.UserAddReq;
import com.rbcdemo.service.abstactions.MenuService;
import com.rbcdemo.service.abstactions.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserroleMapper userroleMapper;
    @Autowired
    private RolemenuMapper rolemenuMapper;
    @Autowired
    private MenuMapper menuMapper;

    @Override
    @Transactional
    public void TransactionTest(UserAddReq req) {

        User user = new User();
        user.setRealname(req.realname);
        user.setPassword(req.password);
        user.setPhone(req.phone);
        user.setRealname(req.realname);
        userMapper.updateByPrimaryKey(user);

        int a = 1 / 0;

        User user2 = new User();
        user2.setRealname(req.realname);
        user2.setPassword(req.password);
        user2.setPhone(req.phone);
        user2.setRealname(req.realname);
        userMapper.insert(user2);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int insert(UserAddReq req) {
        User user = new User();
        user.setLoginname(req.UserName);
        user.setPassword(req.password);
        user.setPhone(req.phone);
        user.setRealname(req.realname);
        userMapper.insert(user);
        if(req.roleids.length>0)
        {
            batchInsetUaerRole(user.getId(),req.roleids);
        }
        return user.getId();
    }

    int batchInsetUaerRole(int userid,int[] roleids) {

        List<Userrole> urList=new ArrayList<>();
        for(int i=0;i<roleids.length;i++)
        {
            Userrole ur=new Userrole();
            ur.setRoleid(roleids[i]);
            ur.setUserid(userid);
            urList.add(ur);
        }
        return userroleMapper.insetBatch(urList);
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
    public int updateByPrimaryKey(UserAddReq req) {
        User user = new User();
        user.setRealname(req.realname);
        user.setPassword(req.password);
        user.setPhone(req.phone);
        user.setRealname(req.realname);
        return userMapper.updateByPrimaryKey(user);
    }

    @Override
    public User findByUsername(User user) {
        return userMapper.findByUsername(user);
    }

    @Override
    public List<Menu> GetUserMenu(int userid) {
        List<Userrole> roleidObjs=userroleMapper.getUserRoleIds(userid);
        List<Integer> roleids=roleidObjs.stream().map(Userrole::getRoleid).collect(Collectors.toList());
        List<Rolemenu> rolemenus= rolemenuMapper.selectbyroleids(roleids);
        List<Integer>  menuids=rolemenus.stream().map(Rolemenu::getMenuid).collect(Collectors.toList());
        return menuMapper.SelectMenuByIds(menuids);
    }


}
