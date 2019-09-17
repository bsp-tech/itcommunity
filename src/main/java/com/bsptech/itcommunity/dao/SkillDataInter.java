package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface SkillDataInter extends JpaRepository<Skill, Integer> {
    public Skill findByName(String name);

    public List<Skill> findByEnabled(Boolean enabled);
}
