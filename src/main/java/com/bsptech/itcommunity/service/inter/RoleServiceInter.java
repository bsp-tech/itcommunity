package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.AuthRole;

import java.util.List;

public interface RoleServiceInter {
    public AuthRole findById(Integer id);

    public List<AuthRole> findAll();

    public AuthRole save(AuthRole role);
    
}
