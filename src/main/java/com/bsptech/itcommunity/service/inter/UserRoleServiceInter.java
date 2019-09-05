package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.Role;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.entity.UserRole;

public interface UserRoleServiceInter {
    public UserRole findByUserId(User user);

    public UserRole findByRoleId(Role role);

    public UserRole save(UserRole userRole);
}
