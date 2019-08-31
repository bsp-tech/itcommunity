package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.RoleDataInter;
import com.bsptech.itcommunity.entity.Role;
import com.bsptech.itcommunity.service.inter.RoleServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class RoleServiceImpl implements RoleServiceInter {
    @Autowired
    RoleDataInter roleDataInter;

    @Override
    public Role findById(Integer id) {
        return roleDataInter.findById(id).get();
    }

    @Override
    public List<Role> findAll() {
        return (List<Role>) roleDataInter.findAll();
    }

    @Override
    public Role save(Role role) {
        return roleDataInter.save(role);
    }
}
