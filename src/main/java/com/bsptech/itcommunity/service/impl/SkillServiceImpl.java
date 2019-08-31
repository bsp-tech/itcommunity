package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.SkillDataInter;
import com.bsptech.itcommunity.entity.Skill;
import com.bsptech.itcommunity.service.inter.SkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class SkillServiceImpl implements SkillServiceInter {
    @Autowired
    SkillDataInter skillDataInter;

    @Override
    public Skill findById(Integer id) {
        return skillDataInter.findById(id).get();
    }

    @Override
    public Skill findByName(String name) {
        return skillDataInter.findByName(name);
    }

    @Override
    public List<Skill> findAll() {
        return (List<Skill>) skillDataInter.findAll();
    }

    @Override
    public Skill save(Skill skill) {
        return skillDataInter.save(skill);
    }
}
