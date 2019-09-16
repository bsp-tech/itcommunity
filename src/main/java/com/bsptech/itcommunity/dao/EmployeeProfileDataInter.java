package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeProfileDataInter extends CrudRepository<EmployeeProfile, Integer> {
    EmployeeProfile findByUserId(User user);
}
