package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.UserDataInter;
import com.bsptech.itcommunity.entity.AuthGroup;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.inter.MailServiceInter;
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

    @Autowired
    MailServiceInter mailServiceInter;

    @Override
    public User findById(Integer id) {
        return userDataInter.findById(id).get();
    }

    @Override
    public User findByEmail(String email) {
        return  userDataInter.findByEmail(email);
    }

    @Override
    public List<User> findAll() {
        return userDataInter.findAll();
    }

    @Override
    public int save(User user) {
        user.setEmail(user.getEmail().trim().toLowerCase());

        User alreadyExist = userDataInter.findByEmail(user.getEmail());
        if(alreadyExist!=null){
            return -1;
        }

        user.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        user.setGroupId(new AuthGroup(2));
        user.setPassword(passwordEncoder.encode(user.getPassword().trim()));

        user.setVerifyEmailCode((int)(Math.random()*((10000-1000))+1000));

        mailServiceInter.sendEmail(user.getEmail(),user.getVerifyEmailCode());

        user.setEnabled(false);
        userDataInter.save(user);

        return user.getId();
    }

    @Override
    public User update(com.bsptech.itcommunity.bean.User user) {
        User newUser = securityServiceInter.getLoggedInUserDetails().getUser();
        newUser = userDataInter.getOne(newUser.getId());

        newUser.setAge(user.getAge());
        newUser.setEmail(user.getEmail().trim().toLowerCase());
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

}
