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
    public void sendEmail(String email, String code) {

        String message = "http://www.myitcareer.net/verify?";
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(email);
        message+= "email=" +email+"&code="+code;
        msg.setSubject("Email Confirmation");
        msg.setText(message);

        javaMailSender.send(msg);

    }
}
