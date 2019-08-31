package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProfileSkill;
import com.bsptech.itcommunity.entity.Skill;

import java.util.List;

public interface EmployeeProfileSkillServiceInter {
    public EmployeeProfileSkill findById(Integer id);

    public List<EmployeeProfileSkill> findAllByEmployeeProfileId(EmployeeProfile employeeProfile);

    public List<EmployeeProfileSkill> findAllBySkillId(Skill skill);

    public List<EmployeeProfileSkill> findAll();

    public EmployeeProfileSkill save(EmployeeProfileSkill employeeProfileSkill);

    public EmployeeProfileSkill update(EmployeeProfileSkill employeeProfileSkill);

    public int delete(Integer id);

}
