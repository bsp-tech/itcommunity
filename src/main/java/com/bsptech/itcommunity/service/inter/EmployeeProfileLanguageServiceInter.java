package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProfileLanguage;
import com.bsptech.itcommunity.entity.Language;

import java.util.List;

public interface EmployeeProfileLanguageServiceInter {
    public EmployeeProfileLanguage findById(Integer id);

    public List<EmployeeProfileLanguage> findAll();

    public List<EmployeeProfileLanguage> findAllByLanguageId(Language language);

    public List<EmployeeProfileLanguage> findAllByEmployeeId(EmployeeProfile employeeProfile);

    public EmployeeProfileLanguage save(EmployeeProfileLanguage employeeProfileLanguage);

    public int delete(Integer id);

}
