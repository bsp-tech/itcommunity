package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.Gender;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.entity.UserGender;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserGenderDataInter extends CrudRepository<UserGender, Integer> {
    public UserGender findByUserId(User user);

    public UserGender findByGenderId(Gender gender);

    public List<UserGender> findAllByGenderId(Gender gender);
}
