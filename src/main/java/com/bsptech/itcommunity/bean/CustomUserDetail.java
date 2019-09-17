package com.bsptech.itcommunity.bean;

import com.bsptech.itcommunity.entity.User;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class CustomUserDetail extends org.springframework.security.core.userdetails.User {
    private User user;

    public CustomUserDetail(User user, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

}
