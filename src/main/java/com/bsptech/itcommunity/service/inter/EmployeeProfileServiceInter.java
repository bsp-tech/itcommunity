package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeProfileServiceInter {
    public EmployeeProfile findById(Integer id);

    public EmployeeProfile findByUserId(User user);

    public List<EmployeeProfile> findAll();
    public List<EmployeeProfile> search(EmployeeProfile employeeProfile, Pageable pageable);


    public EmployeeProfile register(EmployeeProfile employeeProfile);

    public EmployeeProfile update(EmployeeProfile employeeProfile);

    public int delete(Integer id);

    public int joinProject(Integer projectId);

}
