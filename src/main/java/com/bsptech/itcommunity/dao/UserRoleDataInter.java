package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.Role;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.entity.UserRole;
import org.springframework.data.repository.CrudRepository;

public interface UserRoleDataInter extends CrudRepository<UserRole, Integer> {
    UserRole findByUserId(User user);

    UserRole findByRoleId(Role role);
}
