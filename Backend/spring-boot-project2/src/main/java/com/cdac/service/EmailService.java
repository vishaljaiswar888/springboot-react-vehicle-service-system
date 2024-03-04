package com.cdac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cdac.entity.Customer;
import com.cdac.entity.Email;
import com.cdac.entity.ServiceAppointment;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private AppointmentService appService;

//    public void sendThankYouEmail(int cusId) {
//        Customer customer = customerService.fetchById(cusId);
//
//        if (customer != null) {
//            Email email = new Email();
//            email.setRecipient(customer.getEmail());
//            email.setSubject("Thank You for Booking Our Services!");
//            email.setBody("Dear " + customer.getName() + ",\n\n"
//                         + "Thank you for booking our services!\n\n"
//                         + "We are excited to serve you.\n\n"
//                         + "Best regards,\n"
//                         + "Your Service Provider");
//
//            sendEmail(email);
//        }
//    }

    public void sendThankYouEmail(int cusId) {
        ServiceAppointment app = appService.fetchById(cusId);

        if (app != null) {
            Email email = new Email();
            email.setRecipient(app.getEmail());
            email.setSubject("Thank You for Booking Our Services!");
            email.setBody("Dear " + app.getName() + ",\n\n"
                         + "Thank you for booking our services!\n\n"
                         + "We are excited to serve you.\n\n"
                         + "Best regards,\n"
                         + "Your Service Provider");

            sendEmail(email);
        }
    }
    
    private void sendEmail(Email email) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(email.getRecipient());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getBody());

        javaMailSender.send(mailMessage);
    }
}