package com.rbcdemo.web.controller;

import com.rbcdemo.dao.entity.Role;
import com.rbcdemo.model.UserAddReq;
import com.rbcdemo.service.abstactions.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/role")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping(path = "/addRole" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public  String  AddRole(@RequestBody Role req){
         roleService.addRole(req);
         return "success";
    }
}
