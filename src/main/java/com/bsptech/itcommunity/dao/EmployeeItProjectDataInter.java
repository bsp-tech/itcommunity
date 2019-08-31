package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProject;
import com.bsptech.itcommunity.entity.Itproject;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeItProjectDataInter extends CrudRepository<EmployeeProject, Integer> {

    EmployeeProject findAllByEmployeeId(Integer id);

    EmployeeProject findAllByProjectId(Integer id);
}
