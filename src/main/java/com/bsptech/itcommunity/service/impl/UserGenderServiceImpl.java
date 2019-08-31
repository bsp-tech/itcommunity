package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.UserGenderDataInter;
import com.bsptech.itcommunity.entity.Gender;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.entity.UserGender;
import com.bsptech.itcommunity.service.inter.UserGenderServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGenderServiceImpl implements UserGenderServiceInter {
    @Autowired
    UserGenderDataInter userGenderDataInter;

    @Override
    public UserGender findById(Integer id) {
        return userGenderDataInter.findById(id).get();
    }

    @Override
    public List<UserGender> findAll() {
        return (List<UserGender>) userGenderDataInter.findAll();
    }

    @Override
    public UserGender findByUserId(User user) {
        return userGenderDataInter.findByUserId(user);
    }

    @Override
    public UserGender findByGenderId(Gender gender) {
        return userGenderDataInter.findByGenderId(gender);
    }

    @Override
    public List<UserGender> findAllGenderId(Gender gender) {
        return (List<UserGender>) userGenderDataInter.findAllByGenderId(gender);
    }
}
