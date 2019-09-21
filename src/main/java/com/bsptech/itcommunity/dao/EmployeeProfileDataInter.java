package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.Language;
import com.bsptech.itcommunity.entity.Skill;
import com.bsptech.itcommunity.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeProfileDataInter extends CrudRepository<EmployeeProfile, Integer> {
    EmployeeProfile findByUserId(User user);

    List<EmployeeProfile> findDistinctByUserIdNameContainingOrUserIdSurnameContainingOrUserIdPhoneContainingOrUserIdEmailContainingOrEmployeeProfileLanguageList_LanguageIdInAndEmployeeProfileLanguageList_LevelInOrEmployeeProfileSkillList_SkillIdInAndEmployeeProfileSkillList_LevelIn(
            String name,
            String surname,
            String phone,
            String email,
            List<Language> languages,
            List<Integer> levels,
            List<Skill> skills,
            List<Integer> skill);

}
