package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageDataInter extends CrudRepository<Language, Integer> {
    Language findByName(String name);
}
