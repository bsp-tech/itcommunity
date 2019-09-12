package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.EmployeeProfileDataInter;
import com.bsptech.itcommunity.dao.EmployeeProfileLanguageDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProfileLanguage;
import com.bsptech.itcommunity.entity.User;
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

        if (e.getUserId() == null) {
            employeeProfileList = (List<EmployeeProfile>) employeeProfileDataInter.findAll();
        }
//        else {
//            User u = e.getUserId();
//            employeeProfileList = employeeProfileDataInter.find(u.getName(), u.getSurname(), u.getEmail(), u.getPhone());
//        }
        List<EmployeeProfileLanguage> fromView = new ArrayList<>();
        List<EmployeeProfileLanguage> fromDatabase = new ArrayList<>();
        if (e.getEmployeeProfileLanguageList() != null) {
            fromView = e.getEmployeeProfileLanguageList();
            for (EmployeeProfileLanguage empLang : fromView) {
                fromDatabase = employeeProfileLanguageDataInter.findAllByLanguageIdAndLevel(empLang.getLanguageId(), empLang.getLevel());
            }
            for (EmployeeProfileLanguage empLangForAdd : fromDatabase) {
                employeeProfileList.add(empLangForAdd.getEmployeeProfileId());
            }

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
