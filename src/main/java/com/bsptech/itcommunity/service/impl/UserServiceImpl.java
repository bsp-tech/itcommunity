package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.bean.User;
import com.bsptech.itcommunity.dao.UserDataInter;
import com.bsptech.itcommunity.entity.AuthGroup;
import com.bsptech.itcommunity.service.inter.SecurityServiceInter;
import com.bsptech.itcommunity.service.inter.UserServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserServiceInter {
    @Autowired
    UserDataInter userDataInter;

    @Autowired
    private SecurityServiceInter securityServiceInter;

    @Autowired
    @Qualifier("pwdEncoder")
    private PasswordEncoder passwordEncoder;



    @Override
    public com.bsptech.itcommunity.entity.User findById(Integer id) {
        return userDataInter.findById(id).get();
    }

    @Override
    public List<com.bsptech.itcommunity.entity.User> findAll() {
        return (List<com.bsptech.itcommunity.entity.User>) userDataInter.findAll();
    }


    @Override
    public com.bsptech.itcommunity.entity.User save(com.bsptech.itcommunity.entity.User user) {
        user.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        user.setGroupId(new AuthGroup(2));
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword().trim()));
        return userDataInter.save(user);
    }

    @Override
    public com.bsptech.itcommunity.entity.User update(User user) {
        com.bsptech.itcommunity.entity.User newUser = securityServiceInter.getLoggedInUserDetails().getUser();
        newUser = userDataInter.getOne(newUser.getId());

        newUser.setAge(user.getAge());
        newUser.setEmail(user.getEmail());
        newUser.setGenderId(user.getGenderId());
        newUser.setName(user.getName());
        newUser.setSurname(user.getSurname());
        newUser.setPhone(user.getPhone());
        newUser.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
        if(user.getPassword()!=null && !user.getPassword().trim().isEmpty()){
            newUser.setPassword(passwordEncoder.encode(user.getPassword().trim()));
        }

        return userDataInter.save(newUser);
    }

    @Override
    public int delete(Integer id) {
        userDataInter.deleteById(id);
        return 0;
    }
}
