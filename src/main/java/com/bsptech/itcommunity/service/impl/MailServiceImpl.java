package com.bsptech.itcommunity.service.impl;

import com.bsptech.itcommunity.service.inter.MailServiceInter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailServiceInter {

    @Autowired
    JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String email, String code, String subject,String option) {
        System.out.println(subject);
        String base = "http://www.myitcareer.net/"+option+"?";

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(email);

        msg.setSubject(subject);
        msg.setText(base + "email=" + email + "&code=" + code);

        javaMailSender.send(msg);
        System.out.println("Successfully Sended");

    }

//    @Override
//    public void sendResetCode(String email, int code) {
//
//        String base = "http://www.myitcareer.net/reset?";
//
//        SimpleMailMessage msg = new SimpleMailMessage();
//
//        msg.setTo(email);
//
//        msg.setSubject("Reset your password");
//        msg.setText(base + "email=" + email + "&code=" + code);
//
//        javaMailSender.send(msg);
//    } Gerek Yoxdur!!!!!!!

}
