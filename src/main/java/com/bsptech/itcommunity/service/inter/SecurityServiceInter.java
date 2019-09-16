package com.bsptech.itcommunity.service.inter;

import com.bsptech.itcommunity.bean.CustomUserDetail;

public interface SecurityServiceInter {

     CustomUserDetail getLoggedInUserDetails();

     void reloadRoles();
}
