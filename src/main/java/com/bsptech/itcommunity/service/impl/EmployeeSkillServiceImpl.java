package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.EmployeeProfileSkillDataInter;
import com.bsptech.itcommunity.entity.*;
import com.bsptech.itcommunity.service.inter.EmployeeProfileSkillServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class EmployeeSkillServiceImpl implements EmployeeProfileSkillServiceInter {
    @Autowired
    EmployeeProfileSkillDataInter employeeSkillDataInter;

    @Override
    public EmployeeProfileSkill findById(Integer id) {
        return employeeSkillDataInter.findById(id).get();
    }

    @Override
    public List<EmployeeProfileSkill> findAllByEmployeeProfileId(EmployeeProfile employeeProfile) {
        return (List<EmployeeProfileSkill>) employeeSkillDataInter.findAllByEmployeeProfileId(employeeProfile);
    }

    @Override
    public List<EmployeeProfileSkill> findAllBySkillId(Skill skill) {
        return (List<EmployeeProfileSkill>) employeeSkillDataInter.findAllBySkillId(skill);
    }

    @Override
    public List<EmployeeProfileSkill> findAll() {
        return (List<EmployeeProfileSkill>) employeeSkillDataInter.findAll();
    }

    @Override
    public EmployeeProfileSkill save(EmployeeProfileSkill employeeProfileSkill) {
        return employeeSkillDataInter.save(employeeProfileSkill);
    }

    @Override
    public EmployeeProfileSkill update(EmployeeProfileSkill employeeProfileSkill) {
        return employeeSkillDataInter.save(employeeProfileSkill);
    }

    @Override
    public int delete(Integer id) {
        employeeSkillDataInter.deleteById(id);
        return 0;
    }
}
