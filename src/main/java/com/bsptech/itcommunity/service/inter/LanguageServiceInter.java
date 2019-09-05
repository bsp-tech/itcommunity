package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.Language;

import java.util.List;

public interface LanguageServiceInter {
    public Language findById(Integer id);

    public List<Language> findAll();

    public Language findByName(String name);
}
