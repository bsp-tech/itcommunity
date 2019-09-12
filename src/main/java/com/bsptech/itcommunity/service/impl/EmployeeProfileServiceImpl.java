package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.EmployeeProfileDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProfileLanguage;
import com.bsptech.itcommunity.entity.EmployeeProfileSkill;
import com.bsptech.itcommunity.entity.User;
//import com.bsptech.itcommunity.security.SecurityUtil;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileServiceInter {
    @Autowired
    EmployeeProfileDataInter employeeProfileDataInter;


//    @Autowired
//    SecurityUtil securityUtil;

    @Override
    public EmployeeProfile findById(Integer id) {
        return employeeProfileDataInter.findById(id).get();
    }

    @Override
    public EmployeeProfile findByUserId(User user) {
        return employeeProfileDataInter.findByUserId(user);
    }

    @Override
    public List<EmployeeProfile> findAll() {
        return (List<EmployeeProfile>) employeeProfileDataInter.findAll();
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

    @Override
    public EmployeeProfile register(EmployeeProfile employeeProfile) {
        employeeProfile.setApproved(1);
        employeeProfile.setAbout("asadasdads");
        employeeProfile.setSpeciality("bbbbbb");
        employeeProfile.setApprovedDateTime(new java.sql.Date(new Date().getTime()));
        employeeProfile.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
        employeeProfile.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        employeeProfile.setUserId(new User(1));
        List<EmployeeProfileLanguage> epLanguageList = employeeProfile.getEmployeeProfileLanguageList();
        for (EmployeeProfileLanguage epLanguage : epLanguageList) {
            epLanguage.setEmployeeProfileId(employeeProfile);
            epLanguage.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        }
        List<EmployeeProfileSkill> epSkillList = employeeProfile.getEmployeeProfileSkillList();
        for (EmployeeProfileSkill epSkill : epSkillList) {
            epSkill.setEmployeeProfileId(employeeProfile);
            epSkill.setInsertDateTime(new java.sql.Date(new Date().getTime()));
        }
        employeeProfile.setEmployeeProfileLanguageList(epLanguageList);
        employeeProfile.setEmployeeProfileSkillList(epSkillList);
        EmployeeProfile ep = employeeProfileDataInter.save(employeeProfile);
        return employeeProfile;
    }
}
