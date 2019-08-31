package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.EmployeeItProjectDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.EmployeeProject;
import com.bsptech.itcommunity.entity.Itproject;
import com.bsptech.itcommunity.service.inter.EmployeeItProjectServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeProjectServiceImpl implements EmployeeItProjectServiceInter {
    @Autowired
    EmployeeItProjectDataInter employeeItProjectDataInter;

    @Override
    public EmployeeProject findById(Integer id) {
        return employeeItProjectDataInter.findById(id).get();
    }


    @Override
    public List<EmployeeProject> findAllByEmployeeProfileId(EmployeeProfile employeeProfile) {

        return (List<EmployeeProject>) employeeItProjectDataInter.findAllByEmployeeId(employeeProfile.getId());
    }

    @Override
    public List<EmployeeProject> findAllByItProjectId(Itproject itproject) {
        return (List<EmployeeProject>) employeeItProjectDataInter.findAllByProjectId(itproject.getId());
    }

    @Override
    public List<EmployeeProject> findAll() {
        return (List<EmployeeProject>) employeeItProjectDataInter.findAll();
    }

    @Override
    public EmployeeProject save(EmployeeProject employeeProject) {
        return employeeItProjectDataInter.save(employeeProject);
    }

    @Override
    public EmployeeProject update(EmployeeProject employeeProject) {
        return employeeItProjectDataInter.save(employeeProject);
    }

    @Override
    public int delete(Integer id) {
        employeeItProjectDataInter.deleteById(id);
        return 0;
    }
}
