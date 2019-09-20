package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.AuthGroup;
import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.Gender;
import com.bsptech.itcommunity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface UserDataInter extends JpaRepository<User,Integer> {
   public User findByEmailAndEnabled(String email, boolean enabled);

   @Modifying
   @Query("update User u set u.id=?1,u.age=?2,u.email=?3,u.name=?4,u.password=?5,u.surname=?6,u.phone=?7,u.insertDateTime=?8,u.lastUpdateDateTime=?9," +
           "u.thumbnail=?10,u.employeeProfileList=?11,u.genderId=?12,u.groupId=?13,u.enabled=?14")
   public User update(Integer id, Integer age, String email, String name, String password, String surname, String phone, Date insertDateTime,
                      Date lastUpdateDateTime, String thumbnail, List<EmployeeProfile> employeeProfileList, Gender genderId, AuthGroup groupId,boolean enabled);

}
