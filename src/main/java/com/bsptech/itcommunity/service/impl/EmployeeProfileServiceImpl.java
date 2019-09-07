package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.EmployeeProfileDataInter;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import com.bsptech.itcommunity.service.inter.EmployeeProfileServiceInter;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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
    public List<EmployeeProfile> findAll(String name,String surname,String email,String number) {
        
        System.out.println("Service : "+name+" "+surname+" "+email+" "+number);
        
        List<EmployeeProfile> employeeProfileList = (List<EmployeeProfile>) employeeProfileDataInter.findAll();
        
        if(name.equals("") && surname.equals("") && email.equals("") && number.equals("")){
            
            return employeeProfileList;
            
        } else {
            
            List<EmployeeProfile> result = new ArrayList<>();
            
            for(EmployeeProfile employee : employeeProfileList ){
                User user = employee.getUserId();
                
                if(user.getName().toLowerCase().equals(name.toLowerCase())
                        || user.getSurname().toLowerCase().equals(surname.toLowerCase())
                        || user.getEmail().toLowerCase().equals(email.toLowerCase())){
                    
                    result.add(employee);
                }
            }
            
            return result;
        }
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
    public Page<EmployeeProfile> getPaginatedEmployees(Pageable pageable) {
        return employeeProfileDataInter.findAll(pageable);
    }

    @Override
    public List<EmployeeProfile> findAllWithPagianation(int page,String name,String surname,String email,String number) {
        List<EmployeeProfile> list = findAll(name,surname,email,number);
        List<EmployeeProfile> listPagination = new ArrayList();
        
        int firstIndex = page*10-10;
        int lastIndex = page*10-1;
        
        if(lastIndex>list.size()){
            lastIndex=list.size()-1;
        }
        
        for(int i = firstIndex ; i<=lastIndex ; i++){
            listPagination.add(list.get(i));
        }
        
        return listPagination;
    }
}
