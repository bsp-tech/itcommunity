package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.entity.Itproject;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ItProjectServiceInter {
    public List<Itproject> findAll();
    public Itproject findById(Integer id);

}
