package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeeItProjectServiceInter {
    public EmployeeProject findById(Integer id);


    public List<EmployeeProject> findAllByEmployeeProfileId(EmployeeProfile employeeProfile);

    public List<EmployeeProject> findAllByItProjectId(Itproject itproject);

    public List<EmployeeProject> findAll();

    public EmployeeProject save(EmployeeProject employeeProject);

    public EmployeeProject update(EmployeeProject employeeProject);

    public int delete(Integer id);
}
