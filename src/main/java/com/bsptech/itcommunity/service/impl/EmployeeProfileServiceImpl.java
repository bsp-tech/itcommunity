package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.EmployeeProfileDataInter;
import com.bsptech.itcommunity.dao.EmployeeProfileLanguageDataInter;
import com.bsptech.itcommunity.dao.LanguageDataInter;
import com.bsptech.itcommunity.dao.SkillDataInter;
import com.bsptech.itcommunity.dao.UserDataInter;
import com.bsptech.itcommunity.entity.*;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import com.bsptech.itcommunity.service.inter.SecurityServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

//import com.bsptech.itcommunity.security.SecurityUtil;

@Service
@Transactional
public class EmployeeProfileServiceImpl implements EmployeeProfileServiceInter {
    @Autowired
    EmployeeProfileDataInter employeeProfileDataInter;
    @Autowired
    EmployeeProfileLanguageDataInter employeeProfileLanguageDataInter;
    @Autowired
    LanguageDataInter languageDataInter;

//    @Autowired
//    SecurityUtil securityUtil;

    @Override
    public EmployeeProfile findById(Integer id) {
        Optional<EmployeeProfile> op = employeeProfileDataInter.findById(id);
        return op.isPresent()?op.get():null;
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
    private SkillDataInter skillDao;

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

        List<EmployeeProfileSkill> epSkillFilteredList = new ArrayList<>();

        if(epSkillList!=null && epSkillList.size()>0){
            Date now_ = new java.sql.Date(new Date().getTime());

            for (EmployeeProfileSkill epSkill : epSkillList) {
                if(epSkill==null) continue;
                if(epSkill.getSkillId()==null) continue;
                if(epSkill.getLevel()==null || epSkill.getLevel()==0) continue;
                Skill skill_ = new Skill();

                Integer id_ = epSkill.getSkillId().getId();
                if(id_!=null && id_>0){
                    skill_ = skillDao.getOne(id_);
                }else {
                    String name_ = epSkill.getSkillId().getName();
                    if (name_ != null && !name_.trim().isEmpty()) {
                        skill_.setName(name_.trim());
                        skill_.setEnabled(false);
                        skill_.setInsertDateTime(now_);
                    }else{
                        continue;
                    }
                }
//                System.out.println("skill="+skill_);
                epSkill.setSkillId(skill_);
                epSkill.setInsertDateTime(now_);
                epSkill.setEmployeeProfileId(employeeProfile);

                epSkillFilteredList.add(epSkill);
            }
        }
        employeeProfile.setEmployeeProfileLanguageList(epLanguageList);
        employeeProfile.setEmployeeProfileSkillList(epSkillList);
        EmployeeProfile ep = employeeProfileDataInter.save(employeeProfile);

        return ep;
    }
}
