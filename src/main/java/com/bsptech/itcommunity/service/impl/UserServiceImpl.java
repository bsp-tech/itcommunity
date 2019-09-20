package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.UserDataInter;
import com.bsptech.itcommunity.entity.AuthGroup;
import com.bsptech.itcommunity.entity.User;
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
    @Qualifier("pwdEncoder")
    private PasswordEncoder passwordEncoder;


    @Override
    public User findById(Integer id) {
        return userDataInter.findById(id).get();
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userDataInter.findAll();
    }


    @Override
    public User save(User user) {
        user.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        user.setGroupId(new AuthGroup(2));
        user.setEnabled(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userDataInter.save(user);
    }

    @Override
    public User update(User user) {
        user.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        user.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setGroupId(new AuthGroup(2));
        user.setEnabled(true);
        User update= userDataInter.update(user.getId(),user.getAge(),user.getEmail(),user.getName(),user.getPassword()
               ,user.getSurname(),user.getPhone(),user.getInsertDateTime(),user.getLastUpdateDateTime(),user.getThumbnail()
               ,user.getEmployeeProfileList(),user.getGenderId(),user.getGroupId(),user.getEnabled());
        return update;
    }

    @Override
    public int delete(Integer id) {
        userDataInter.deleteById(id);
        return 0;
    }
}
