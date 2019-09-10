package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.EmployeeProfileDataInter;
import com.bsptech.itcommunity.dao.UserDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

@Service
public class EmployeeProfileServiceImpl implements EmployeeProfileServiceInter {
    @Autowired
    EmployeeProfileDataInter employeeProfileDataInter;
   
    @Override
    public EmployeeProfile findById(Integer id) {
        return employeeProfileDataInter.findById(id).get();
    }

    @Override
    public EmployeeProfile findByUserId(User user) {
        return employeeProfileDataInter.findByUserId(user);
    }

    @Override
    public List<EmployeeProfile> findAll() {
        return (List<EmployeeProfile>) employeeProfileDataInter.findAll();
    }

    @Override
    public EmployeeProfile save(EmployeeProfile employeeProfile) {
    	
        return employeeProfileDataInter.save(employeeProfile);
    }

    @Override
    public EmployeeProfile update(EmployeeProfile employeeProfile) {
        return employeeProfileDataInter.save(employeeProfile);
    }

    @Override
    public int delete(Integer id) {
        employeeProfileDataInter.deleteById(id);
        return 0;
    }

	@Override
	public EmployeeProfile save(EmployeeProfile employeeProfile, HttpSession session) {
		employeeProfile.setApproved(1);
    	employeeProfile.setApprovedDateTime(new java.sql.Date(new Date().getTime()));
    	employeeProfile.setLastUpdateDateTime(new java.sql.Date(new Date().getTime()));
    	employeeProfile.setInsertDateTime(new java.sql.Date(new Date().getTime()));
    	//when user logged in set session attribute
    	//employeeProfile.setUserId((User)session.getAttribute("s_user"));
    	employeeProfile.setUserId(new User(1));
		EmployeeProfile ep = employeeProfileDataInter.save(employeeProfile);
		return employeeProfile;
	}
}
