package com.rbcdemo.web.controller;

import com.rbcdemo.core.annotation.UserLoginToken;
import com.rbcdemo.dao.entity.Menu;
import com.rbcdemo.dao.entity.Role;
import com.rbcdemo.service.abstactions.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/menu")

public class MenuController {
    @Autowired
    MenuService menuService;

    @UserLoginToken
    @PostMapping(path = "/addMenu" ,produces = MediaType.APPLICATION_JSON_VALUE)
    public  int  AddMenu(@RequestBody Menu req){

        return menuService.addMenu(req);
    }
}
