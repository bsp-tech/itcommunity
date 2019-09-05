package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.Itproject;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface ItProjectDataInter extends CrudRepository<Itproject, Integer> {
}
