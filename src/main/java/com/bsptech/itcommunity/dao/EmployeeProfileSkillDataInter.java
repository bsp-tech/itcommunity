package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProfileSkill;
import com.bsptech.itcommunity.entity.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeProfileSkillDataInter extends CrudRepository<EmployeeProfileSkill, Integer> {
    List<EmployeeProfileSkill> findAllByEmployeeProfileId(EmployeeProfile employeeProfile);

    List<EmployeeProfileSkill> findAllBySkillId(Skill skill);
}
