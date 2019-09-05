package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.Itproject;
import com.bsptech.itcommunity.entity.ProjectSkill;
import com.bsptech.itcommunity.entity.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItProjectSkillDataInter extends CrudRepository<ProjectSkill, Integer> {
    List<ProjectSkill> findAllByProjectId(Itproject itproject);

    List<ProjectSkill> findBySkillId(Skill skill);
}
