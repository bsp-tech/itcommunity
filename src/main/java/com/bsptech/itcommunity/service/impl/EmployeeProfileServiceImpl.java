package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.EmployeeProfileDataInter;
import com.bsptech.itcommunity.dao.UserDataInter;
import com.bsptech.itcommunity.entity.*;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.SecurityServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Date;
import java.util.List;

//import com.bsptech.itcommunity.security.SecurityUtil;

@Service
@Transactional
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

    @Autowired
    private SecurityServiceInter securityService;

    @Autowired
    private UserDataInter userDao;

    @Override
    public EmployeeProfile register(EmployeeProfile employeeProfile) {
        employeeProfile.setApproved(1);
        employeeProfile.setApprovedDateTime(new java.sql.Date(new Date().getTime()));
        employeeProfile.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
        employeeProfile.setInsertDateTime(new java.sql.Date(new Date().getTime()));

        User loggedInUser = userDao.getOne(securityService.getLoggedInUserDetails().getUser().getId());
        loggedInUser.setGroupId(new AuthGroup(3));
        employeeProfile.setUserId(loggedInUser);
        List<EmployeeProfileLanguage> epLanguageList = employeeProfile.getEmployeeProfileLanguageList();
        if(epLanguageList!=null && epLanguageList.size()>0){
            for (EmployeeProfileLanguage epLanguage : epLanguageList) {
                epLanguage.setEmployeeProfileId(employeeProfile);
                epLanguage.setInsertDateTime(new java.sql.Date(new Date().getTime()));
            }
        }
        List<EmployeeProfileSkill> epSkillList = employeeProfile.getEmployeeProfileSkillList();
        if(epSkillList!=null && epSkillList.size()>0){
            for (EmployeeProfileSkill epSkill : epSkillList) {
                epSkill.setEmployeeProfileId(employeeProfile);
                epSkill.setInsertDateTime(new java.sql.Date(new Date().getTime()));
            }
        }
        employeeProfile.setEmployeeProfileLanguageList(epLanguageList);
        employeeProfile.setEmployeeProfileSkillList(epSkillList);
        EmployeeProfile ep = employeeProfileDataInter.save(employeeProfile);

        return ep;
    }
}
