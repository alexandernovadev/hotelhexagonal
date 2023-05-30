package com.hotels.mart.application.services.emails;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

  @Autowired
  JavaMailSender javaMailSender;

  public String sendEmail(String emailform, String emailto, String subject, String body) {
    SimpleMailMessage message = new SimpleMailMessage();

    message.setFrom(emailform);
    message.setTo(emailto);
    message.setSubject(subject);
    message.setText(body);

    javaMailSender.send(message);

    return "Mail sent successfully";
  }

  public String sendEmailwithAttachment() {
    try {
      MimeMessage message = javaMailSender.createMimeMessage();

      MimeMessageHelper messageHelper = new MimeMessageHelper(message, true);

      messageHelper.setFrom("");
      messageHelper.setTo("");
      messageHelper.setSubject("Test Subject");
      messageHelper.setText("Test Body");

      File file = new File("Path To File");

      messageHelper.addAttachment(file.getName(), file);

      javaMailSender.send(message);

      return "Mail sent successfully";

    } catch (Exception e) {
      return "Mail sent failed";
    }
  }
}
