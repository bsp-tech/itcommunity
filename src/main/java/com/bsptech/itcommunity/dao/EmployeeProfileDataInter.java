package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.EmployeeProfile;
import com.bsptech.itcommunity.entity.Language;
import com.bsptech.itcommunity.entity.Skill;
import com.bsptech.itcommunity.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeProfileDataInter extends CrudRepository<EmployeeProfile, Integer> {
    EmployeeProfile findByUserId(User user);

    //    @Query(value = "select e from EmployeeProfile e " +
//            "left join e.employeeProfileLanguageList el on el.id=e.id " +
//            "left join e.userId u on u.id=e.id " +
//            "where el.languageId in(langIds) or " +
//            "u.name =:name OR " +
//            "u.surname =:surname OR " +
//            "u.email =:email OR " +
//            "u.phone =:phone", nativeQuery = true
//    )
    List<EmployeeProfile> findDistinctByUserIdNameLikeOrUserIdSurnameLikeOrUserIdPhoneLikeOrUserIdEmailLikeOrEmployeeProfileLanguageList_LanguageIdInAndEmployeeProfileLanguageList_LevelInOrEmployeeProfileSkillList_SkillIdInAndEmployeeProfileSkillList_LevelIn(
            String name,
            String surname,
            String phone,
            String email,
            List<Language> languages,
            List<Integer> levels,
            List<Skill> skills,
            List<Integer> skill);

}
