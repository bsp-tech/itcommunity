package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.*;

import java.util.List;

public interface ItProjectSkillServiceInter {

    public ProjectSkill findById(Integer id);

    public List<ProjectSkill> findAll();

    public List<ProjectSkill> findAllByItProjectId(Itproject itproject);

    public List<ProjectSkill> findAllBySkillId(Skill skill);

    public ProjectSkill save(ProjectSkill projectSkill);

    public ProjectSkill update(ProjectSkill projectSkill);

    public int delete(Integer id);
}
