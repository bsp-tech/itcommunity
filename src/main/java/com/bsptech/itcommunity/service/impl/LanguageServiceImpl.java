package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.dao.LanguageDataInter;
import com.bsptech.itcommunity.entity.Language;
import com.bsptech.itcommunity.service.inter.LanguageServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class LanguageServiceImpl implements LanguageServiceInter {
    @Autowired
    LanguageDataInter languageDataInter;

    @Override
    public Language findById(Integer id) {
        return languageDataInter.findById(id).get();
    }

    @Override
    public List<Language> findAll() {
        return (List<Language>) languageDataInter.findAll();
    }

    @Override
    public Language findByName(String name) {
        return languageDataInter.findByName(name);
    }
}
