package com.bsptech.itcommunity.service.inter;


import com.bsptech.itcommunity.entity.User;

import java.util.List;

public interface UserServiceInter {
    public User findById(Integer id);

    public List<User> findAll();

    public User save(User user);

    public User update(User user);

    public int delete(Integer id);
}
