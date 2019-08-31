package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.ItProjectSkillDataInter;
import com.bsptech.itcommunity.entity.Itproject;
import com.bsptech.itcommunity.entity.ProjectSkill;
import com.bsptech.itcommunity.entity.Skill;
import com.bsptech.itcommunity.service.inter.ItProjectSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ItProjectSkillServiceImpl implements ItProjectSkillServiceInter {
    @Autowired
    ItProjectSkillDataInter itProjectSkillDataInter;

    @Override
    public ProjectSkill findById(Integer id) {
        return itProjectSkillDataInter.findById(id).get();
    }

    @Override
    public List<ProjectSkill> findAll() {
        return (List<ProjectSkill>) itProjectSkillDataInter.findAll();
    }

    @Override
    public List<ProjectSkill> findAllByItProjectId(Itproject itproject) {
        return itProjectSkillDataInter.findAllByProjectId(itproject);
    }

    @Override
    public List<ProjectSkill> findAllBySkillId(Skill skill) {
        return itProjectSkillDataInter.findBySkillId(skill);
    }

    @Override
    public ProjectSkill save(ProjectSkill projectSkill) {
        return itProjectSkillDataInter.save(projectSkill);
    }

    @Override
    public ProjectSkill update(ProjectSkill projectSkill) {
        return itProjectSkillDataInter.save(projectSkill);
    }

    @Override
    public int delete(Integer id) {
        itProjectSkillDataInter.deleteById(id);
        return 0;
    }
}
