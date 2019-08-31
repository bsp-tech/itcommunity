package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.Skill;

import javax.validation.constraints.Max;
import java.util.List;

public interface SkillServiceInter {
    public Skill findById(Integer id);

    public Skill findByName(String name);

    public List<Skill> findAll();

    public Skill save(Skill skill);

}
