package com.example.mailapp.service;

import com.example.mailapp.model.NotificationEmail;
import com.example.mailapp.repository.UserRepository;
import com.example.mailapp.model.Users;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@Slf4j
public class AddUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailService mailService;


    public AddUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String addUser(Users user){



        user.setName(user.getName());
        user.setSurname(user.getSurname());
        user.setPassword(user.getPassword());
        user.setEmail(user.getEmail());
        user.setAge(user.getAge());
        user.setLocalDate(localDate());
        user.setLocalTime(localTime());
        user.setNewsletter(user.getNewsletter());


        if(user.getEmail()!=null) {
            userRepository.save(user);
            log.info("User created");

            mailService.sendMail(new NotificationEmail("Visit our page", user.getEmail(), "Thank you for creating account at Peetkovski.com"  ));
            return "User added";
        }
        else {
            log.warn("Creating user failed");
            return "Not added";
        }
    }

    public String sendMail(){


       return "Null";
    }


    public LocalDate localDate(){

        LocalDate localDate = LocalDate.now();


        return localDate;
    }

    public LocalTime localTime(){

        LocalTime localTime = LocalTime.now();

        return localTime;
    }


}
