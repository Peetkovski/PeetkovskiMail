package com.example.mailapp.controller;

import com.example.mailapp.model.NotificationEmail;
import com.example.mailapp.repository.UserRepository;
import com.example.mailapp.service.AutomaticMailsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@AllArgsConstructor
public class MailController {

    private final AutomaticMailsService automaticMailsService;
    private final UserRepository userRepository;


    @RequestMapping(value = "/email_send", method = RequestMethod.GET)
    public String goToAllEmails(Model model){

        NotificationEmail notificationEmail = new NotificationEmail();


        model.addAttribute("emails",notificationEmail);
        model.addAttribute("users", userRepository.findAll());

        return "email_send";
    }

    @PostMapping("/email/send")
    public ResponseEntity<String> sendEmail(@ModelAttribute("mail") NotificationEmail notificationEmail){

        automaticMailsService.sendMailToOneUser(notificationEmail);


        return new ResponseEntity<>("Email sent to one user", HttpStatus.OK);
    }

    @PostMapping("/email_send")
    public String email_send(@ModelAttribute("emails") NotificationEmail emails){
        automaticMailsService.sendMailToAllUsers(emails);

        return "email_send";
    }

    @GetMapping("/newsletter")
    public String goToNewsLetter(Model model){

        NotificationEmail notificationEmail = new NotificationEmail();

        model.addAttribute("usersNewsLetter", userRepository.findUsersByNewsletter(true));
        model.addAttribute("emails", notificationEmail);

        return "email_send_newsletter";
    }

    @PostMapping("/newsletter")
    public String newsletter(@ModelAttribute("emails") NotificationEmail emails){
        automaticMailsService.sendMailToNewsLetter(emails);

        return "email_send_newsletter";
    }



}
