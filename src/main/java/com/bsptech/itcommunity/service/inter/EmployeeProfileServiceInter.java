package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeProfileServiceInter {
    public EmployeeProfile findById(Integer id);

    public EmployeeProfile findByUserId(User user);

    public Page<EmployeeProfile> findAll(Pageable pageable);
    public Page<EmployeeProfile> search(EmployeeProfile employeeProfile, Pageable pageable);


    public EmployeeProfile register(EmployeeProfile employeeProfile);

    public EmployeeProfile update(EmployeeProfile employeeProfile);

    public int delete(Integer id);

    public int joinProject(Integer projectId);

}
