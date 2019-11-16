package com.bsptech.itcommunity.service.inter;

public interface MailServiceInter {

    void sendEmail(String email,String  code,String subject,String option);

//    void sendResetCode(String email,int code);
}
