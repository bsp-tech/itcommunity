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
    public void sendEmail(String email, int code) {

        String base = "http://www.myitcareer.net/verify?";

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(email);

        msg.setSubject("Confirm your email address");
        msg.setText(base + "email=" +email+"&code="+code);

        javaMailSender.send(msg);

    }

    @Override
    public void sendResetCode(String email, int code) {

        String base = "http://www.myitcareer.net/reset?";

        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setTo(email);

        msg.setSubject("Reset your password");
        msg.setText(base + "email=" +email+"&code="+code);

        javaMailSender.send(msg);
    }
}
