package com.bsptech.itcommunity.dao;

import com.bsptech.itcommunity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDataInter extends JpaRepository<User,Integer> {
   public User findByEmail(String email);
}
