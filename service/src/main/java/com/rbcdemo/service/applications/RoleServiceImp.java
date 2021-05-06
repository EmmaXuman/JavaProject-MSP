package com.rbcdemo.service.applications;

import com.rbcdemo.dao.entity.Role;
import com.rbcdemo.dao.mapper.RoleMapper;
import com.rbcdemo.service.abstactions.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImp implements RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Override
    public int addRole(Role role) {

        return roleMapper.insert(role);
    }
}
