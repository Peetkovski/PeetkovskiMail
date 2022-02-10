package com.example.mailapp.controller;

import com.example.mailapp.model.NotificationEmail;
import com.example.mailapp.service.AutomaticMailsService;
import com.example.mailapp.service.MailService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@AllArgsConstructor
public class MailController {

    private final AutomaticMailsService automaticMailsService;

    @PostMapping("/email/send")
    public ResponseEntity<String> sendEmail(@RequestBody NotificationEmail notificationEmail){

        automaticMailsService.sendMailToOneUser(notificationEmail);

        


        return new ResponseEntity<>("Email sent to one user", HttpStatus.OK);
    }

    @PostMapping("/email/all")
    public ResponseEntity<String> sendEmailToAll(@RequestBody NotificationEmail notificationEmail){
        automaticMailsService.sendMailToAllUsers(notificationEmail);

        return new ResponseEntity<>("Emails sent to all users",HttpStatus.OK);
    }

    @PostMapping("/email/news")
    public ResponseEntity<String> sendEmailToNewsLetter(@RequestBody NotificationEmail notificationEmail){
        automaticMailsService.sendMailToNewsLetter(notificationEmail);

        return new ResponseEntity<>("Emails sent to newsLetter",HttpStatus.OK);
    }



}
