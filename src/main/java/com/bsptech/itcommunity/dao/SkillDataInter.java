package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.Skill;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface SkillDataInter extends CrudRepository<Skill, Integer> {
    public Skill findByName(String name);
}
