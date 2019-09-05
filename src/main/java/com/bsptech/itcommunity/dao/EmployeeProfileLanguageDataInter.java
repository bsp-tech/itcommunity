package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProfileLanguage;
import com.bsptech.itcommunity.entity.Language;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeProfileLanguageDataInter extends CrudRepository<EmployeeProfileLanguage, Integer> {
    public List<EmployeeProfileLanguage> findAllByEmployeeProfileId(EmployeeProfile employeeProfile);

    public List<EmployeeProfileLanguage> findAllByLanguageId(Language language);

}
