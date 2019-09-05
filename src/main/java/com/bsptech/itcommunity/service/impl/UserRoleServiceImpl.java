package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.UserRoleDataInter;
import com.bsptech.itcommunity.entity.Role;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.entity.UserRole;
import com.bsptech.itcommunity.service.inter.UserRoleServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class UserRoleServiceImpl implements UserRoleServiceInter {
    @Autowired
    UserRoleDataInter userRoleDataInter;

    @Override
    public UserRole findByUserId(User user) {
        return userRoleDataInter.findByUserId(user);

    }

    @Override
    public UserRole findByRoleId(Role role) {
        return userRoleDataInter.findByRoleId(role);
    }

    @Override
    public UserRole save(UserRole userRole) {
        return userRoleDataInter.save(userRole);
    }
}
