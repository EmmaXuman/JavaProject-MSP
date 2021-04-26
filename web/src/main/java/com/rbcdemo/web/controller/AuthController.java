package com.rbcdemo.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.rbcdemo.core.annotation.UserLoginToken;
import com.rbcdemo.dao.entity.User;
import com.rbcdemo.service.TokenService;
import com.rbcdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class AuthController {
    @Autowired
    UserService userservice;
    @Autowired
    TokenService tokenService;

    @PostMapping("/login")
    public Object login(@RequestBody User user){
        JSONObject jsonObject=new JSONObject();
        User userForBase=userservice.findByUsername(user);
        if(userForBase==null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getUserPassword().equals(user.getUserPassword())){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("token", token);
                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }

    @UserLoginToken
    @GetMapping("/getMessage")
    public String getMessage(){
        return "你已通过验证";
    }

}
