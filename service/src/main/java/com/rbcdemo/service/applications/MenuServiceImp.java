package com.rbcdemo.service.applications;

import com.rbcdemo.dao.entity.Menu;
import com.rbcdemo.dao.mapper.MenuMapper;
import com.rbcdemo.service.abstactions.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuServiceImp implements MenuService {
    @Autowired
    MenuMapper menuMapper;
    @Override
    public int addMenu(Menu menu) {
         menuMapper.insert(menu);
        return menu.getId();
    }
}
