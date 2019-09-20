package com.bsptech.itcommunity.service.inter;


import com.bsptech.itcommunity.bean.User;

import java.util.List;

public interface UserServiceInter {
    public com.bsptech.itcommunity.entity.User findById(Integer id);

    public List<com.bsptech.itcommunity.entity.User> findAll();

    public com.bsptech.itcommunity.entity.User save(com.bsptech.itcommunity.entity.User user);

        public com.bsptech.itcommunity.entity.User update(User user);

    public int delete(Integer id);
}
