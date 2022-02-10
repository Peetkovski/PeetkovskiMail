package com.example.mailapp;

import com.example.mailapp.service.AddUserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class MailAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailAppApplication.class, args);


        //TODO STRONA DO ZROBIENIA I REJESTRACJI
        //TODO STRONA DO LOGOWANIA
        //TODO STRONA DO ZARZĄDZANIA MAILAMI
    }

}
