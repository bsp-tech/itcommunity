package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;


@Transactional
public interface EmployeeProfileDataInter extends CrudRepository<EmployeeProfile, Integer> {

    EmployeeProfile findByUserId(User user);
    
    @Query("SELECT DISTINCT " +
            "e " +
            "FROM EmployeeProfile e " +
            "LEFT JOIN User u ON u.id = e.userId " +
            "LEFT JOIN EmployeeProfileLanguage el ON el.employeeProfileId = e.id " +
            "LEFT JOIN EmployeeProfileSkill es ON es.employeeProfileId = e.id " +
            "WHERE " +
            "u.name =:name OR " +
            "u.surname =:surname OR " +
            "u.email =:email OR " +
            "u.phone =:phone"
    )
    List<EmployeeProfile> find(
            @Param("name") String name,
            @Param("surname") String surname,
            @Param("email") String email,
            @Param("phone") String phone
    );
    
}
