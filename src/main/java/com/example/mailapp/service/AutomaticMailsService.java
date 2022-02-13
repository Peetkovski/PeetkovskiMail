package com.example.mailapp.service;

import com.example.mailapp.model.NotificationEmail;
import com.example.mailapp.model.Users;
import com.example.mailapp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class AutomaticMailsService {

    @Autowired
    private MailService mailService;

    @Autowired
    private UserRepository userRepository;



    public String sendMailToOneUser(NotificationEmail notificationEmail){



            mailService.sendMail(new NotificationEmail(notificationEmail.getSubject(), notificationEmail.getRecipient(),notificationEmail.getBody()));


        return "Emails sent";
    }


    public String sendMailToAllUsers(NotificationEmail notificationEmail){

        Iterable<Users> users = userRepository.findAll();


        for(Users s: users) {
            mailService.sendMail(new NotificationEmail(notificationEmail.getSubject() + " " + s.getName(), s.getEmail(), notificationEmail.getBody()));
        }

        return "Emails sent";
    }


    public String sendMailToNewsLetter(NotificationEmail notificationEmail){


        Iterable<Users> users = userRepository.findUsersByNewsletter(true);


        for(Users s: users){

            mailService.sendMail(new NotificationEmail(notificationEmail.getSubject() + " " + s.getName(), s.getEmail(),notificationEmail.getBody()));

        }

        return "NewsLetter sent";
    }

}
