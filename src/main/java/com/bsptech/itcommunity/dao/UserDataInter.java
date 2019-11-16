package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

public interface UserDataInter extends JpaRepository<User,Integer> {
   public User findByEmailAndEnabled(String email, boolean enabled);
   public User findByEmail(String email);
}
