package com.bsptech.itcommunity.service.inter;


import com.bsptech.itcommunity.entity.User;

import java.util.List;

public interface UserServiceInter {
    public User findById(Integer id);

    public List<User> findAll();

    public User findByEmail(String email);

    public int save(User user);

    public User update(com.bsptech.itcommunity.bean.User user);
}
