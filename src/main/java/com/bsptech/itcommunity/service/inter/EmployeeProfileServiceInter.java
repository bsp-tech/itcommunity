package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeProfileServiceInter {
    public EmployeeProfile findById(Integer id);

    public EmployeeProfile findByUserId(User user);

    public List<EmployeeProfile> findAll(String name,String surname,String email,String number);
    
    public EmployeeProfile save(EmployeeProfile employeeProfile);

    public EmployeeProfile update(EmployeeProfile employeeProfile);

    public int delete(Integer id);
    
    public Page<EmployeeProfile> getPaginatedEmployees(Pageable pageable);
    
    public List<EmployeeProfile> findAllWithPagianation(int page,String name,String surname,String email,String number);
}
