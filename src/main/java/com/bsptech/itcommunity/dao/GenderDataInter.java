package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.Gender;
import org.springframework.data.repository.CrudRepository;

public interface GenderDataInter extends CrudRepository<Gender, Integer> {
}
