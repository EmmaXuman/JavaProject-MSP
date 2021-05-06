package com.rbcdemo.web.controller;

import com.google.gson.Gson;
import com.rbcdemo.dao.entity.User;
import com.rbcdemo.model.UserAddReq;
import com.rbcdemo.service.abstactions.UserService;
import com.rbcdemo.viewmodel.BaseVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/getUser")
    public String getUser(int id) {
        User user=userService.selectByPrimaryKey(id);
        return  new Gson().toJson(user);
    }

    @PostMapping(path = "/updateUser",produces = MediaType.APPLICATION_JSON_VALUE)
    public String updateUser(@RequestBody UserAddReq req){
        userService.updateByPrimaryKey(req);
        return "success!";
    }

    @PostMapping(path = "/addUser",produces = MediaType.APPLICATION_JSON_VALUE)
    public String addUser(@RequestBody UserAddReq req){
        userService.insert(req);
        return "success!";
    }

    @GetMapping("/deleteUser")
    public String deleteUser(int id){
        userService.deleteByPrimaryKey(id);
        return "success!";
    }

    @GetMapping("/getUserList")
    public List<User> getUserList(String username, String password){
        return userService.selectAll();
    }

    @PostMapping(path = "/testTransaction" ,produces =MediaType.APPLICATION_JSON_VALUE)
    public  void  testTransaction(@RequestBody UserAddReq req){
        userService.TransactionTest(req);
    }

}
