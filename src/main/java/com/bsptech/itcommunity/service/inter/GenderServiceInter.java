package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.Gender;

import java.util.List;

public interface GenderServiceInter {
    public Gender findById(Integer id);

    public List<Gender> findAll();

    public Gender save(Gender gender);
    

}
