package com.bsptech.itcommunity.service.impl;


import com.bsptech.itcommunity.dao.EmployeeProfileLanguageDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProfileLanguage;
import com.bsptech.itcommunity.entity.Language;
import com.bsptech.itcommunity.service.inter.EmployeeProfileLanguageServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProfileLanguageServiceImpl implements EmployeeProfileLanguageServiceInter {
    @Autowired
    EmployeeProfileLanguageDataInter employeeLanguage;

    @Override
    public EmployeeProfileLanguage findById(Integer id) {
        return employeeLanguage.findById(id).get();
    }

    @Override
    public List<EmployeeProfileLanguage> findAll() {
        return (List<EmployeeProfileLanguage>) employeeLanguage.findAll();
    }

    @Override
    public List<EmployeeProfileLanguage> findAllByLanguageId(Language language) {

        return (List<EmployeeProfileLanguage>) employeeLanguage.findAllByLanguageId(language);
    }

    @Override
    public List<EmployeeProfileLanguage> findAllByEmployeeId(EmployeeProfile employeeProfile) {
        return employeeLanguage.findAllByEmployeeProfileId(employeeProfile);
    }

    @Override
    public EmployeeProfileLanguage save(EmployeeProfileLanguage employeeProfileLanguage) {
        return employeeLanguage.save(employeeProfileLanguage);
    }

    @Override
    public int delete(Integer id) {
        employeeLanguage.deleteById(id);
        return 0;
    }

    @Override
    public List<EmployeeProfileLanguage> findAllByLanguageAndLevel(Language language, Integer level) {
        return (List<EmployeeProfileLanguage>) employeeLanguage.findAllByLanguageIdAndLevel(language, level);
    }
}