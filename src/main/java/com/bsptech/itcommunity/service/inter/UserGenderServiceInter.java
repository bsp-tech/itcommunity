package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.Gender;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.entity.UserGender;

import java.util.List;

public interface UserGenderServiceInter {
    public UserGender findById(Integer id);

    public List<UserGender> findAll();

    public UserGender findByUserId(User user);

    public UserGender findByGenderId(Gender gender);

    public List<UserGender> findAllGenderId(Gender gender);


}
