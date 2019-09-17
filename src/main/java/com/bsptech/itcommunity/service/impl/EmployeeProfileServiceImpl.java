package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.EmployeeProfileDataInter;
import com.bsptech.itcommunity.dao.EmployeeProfileLanguageDataInter;
import com.bsptech.itcommunity.dao.LanguageDataInter;
import com.bsptech.itcommunity.entity.*;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileServiceInter {
    @Autowired
    EmployeeProfileDataInter employeeProfileDataInter;
    @Autowired
    EmployeeProfileLanguageDataInter employeeProfileLanguageDataInter;
    @Autowired
    LanguageDataInter languageDataInter;

    @Override
    public EmployeeProfile findById(Integer id) {
        return employeeProfileDataInter.findById(id).get();
    }

    @Override
    public EmployeeProfile findByUserId(User user) {
        return employeeProfileDataInter.findByUserId(user);
    }

    @Override
    public List<EmployeeProfile> findAll(EmployeeProfile e) {

        List<EmployeeProfile> employeeProfileList = new ArrayList<>();
        List<Language> languages = new ArrayList<>();
        List<Integer> langLevels = new ArrayList<>();
        List<Skill> skills = new ArrayList<>();
        List<Integer> skillLevels = new ArrayList<>();
        if (e.getEmployeeProfileLanguageList() != null) {
            for (EmployeeProfileLanguage l : e.getEmployeeProfileLanguageList()) {
                languages.add(l.getLanguageId());
                langLevels.add(l.getLevel());
            }

        }
        if (e.getEmployeeProfileSkillList() != null) {
            for (EmployeeProfileSkill l : e.getEmployeeProfileSkillList()) {
                skills.add(l.getSkillId());
                skillLevels.add(l.getLevel());
            }
        }
        if (e.getUserId() == null) {
            employeeProfileList = (List<EmployeeProfile>) employeeProfileDataInter.findAll();
        } else {
            User u = e.getUserId();
            employeeProfileList = employeeProfileDataInter.findDistinctByUserIdNameLikeOrUserIdSurnameLikeOrUserIdPhoneLikeOrUserIdEmailLikeOrEmployeeProfileLanguageList_LanguageIdInAndEmployeeProfileLanguageList_LevelInOrEmployeeProfileSkillList_SkillIdInAndEmployeeProfileSkillList_LevelIn(e.getUserId().getName()
                    , e.getUserId().getSurname(), e.getUserId().getPhone(), e.getUserId().getEmail()
                    , languages,
                    langLevels, skills, skillLevels);
        }
        return employeeProfileList;
    }

    @Override
    public EmployeeProfile save(EmployeeProfile employeeProfile) {
        return employeeProfileDataInter.save(employeeProfile);
    }

    @Override
    public EmployeeProfile update(EmployeeProfile employeeProfile) {
        return employeeProfileDataInter.save(employeeProfile);
    }

    @Override
    public int delete(Integer id) {
        employeeProfileDataInter.deleteById(id);
        return 0;
    }
}
