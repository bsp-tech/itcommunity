package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.ItProjectDataInter;
import com.bsptech.itcommunity.entity.Itproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.bsptech.itcommunity.service.inter.ItProjectServiceInter;

@Service
public class ItProjectServiceImpl implements ItProjectServiceInter {

    @Autowired
    private ItProjectDataInter projectDataInter;

    @Override
    public List<Itproject> findAll() {
        List<Itproject> ıtProjectList = (List<Itproject>) projectDataInter.findAll();
        return ıtProjectList;
    }

    @Override
    public Itproject findById(Integer id) {
        return projectDataInter.findById(id).get();
    }
}
