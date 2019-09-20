package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;

import java.util.List;

public interface EmployeeProfileServiceInter {
    public EmployeeProfile findById(Integer id);

    public EmployeeProfile findByUserId(User user);

    public List<EmployeeProfile> search(EmployeeProfile employeeProfile);
    
    public EmployeeProfile save(EmployeeProfile employeeProfile);

    public List<EmployeeProfile> findAll();

    public EmployeeProfile register(EmployeeProfile employeeProfile);

    public EmployeeProfile update(EmployeeProfile employeeProfile);

    public int delete(Integer id);
    
}
