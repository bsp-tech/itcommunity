package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.Role;

import java.util.List;

public interface RoleServiceInter {
    public Role findById(Integer id);

    public List<Role> findAll();

    public Role save(Role role);
    
}
