package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.GenderDataInter;
import com.bsptech.itcommunity.entity.Gender;
import com.bsptech.itcommunity.service.inter.GenderServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenderServiceImpl implements GenderServiceInter {
    @Autowired
    GenderDataInter genderDataInter;

    @Override
    public Gender findById(Integer id) {
        return genderDataInter.findById(id).get();
    }

    @Override
    public List<Gender> findAll() {
        return (List<Gender>) genderDataInter.findAll();
    }

    @Override
    public Gender save(Gender gender) {
        return genderDataInter.save(gender);
    }
}
