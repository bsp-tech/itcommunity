package com.bsptech.itcommunity.service.inter;

public interface MailServiceInter {

    void sendEmail(String email,int code);

    void sendResetCode(String email,int code);
}
