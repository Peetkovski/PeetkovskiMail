package com.example.mailapp;

import com.example.mailapp.model.Users;
import com.example.mailapp.service.AddUserService;
import com.example.mailapp.service.AutomaticMailsService;
import com.example.mailapp.service.GetUserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class UserRepositoryTest {

    @Autowired
    private AddUserService addUserService;

    @Autowired
    private GetUserService getUserService;

    @Autowired
    private AutomaticMailsService automaticMailsService;





    @Test
    @DisplayName("Save Users to Database")
    void saveUser(){

        String users = addUserService.addUser(new Users(
                null,
                "Tomasz",
                "Essowy",
                "Koxu12345",
                "Tomasz@wp.pl",
                17,
                addUserService.localDate(),
                addUserService.localTime(),
                true
        ));
        Assertions.assertEquals("User added", users);
    }

    @Test
    @DisplayName("Adding users to database Failed")
    void not_saveUser(){

        String users = addUserService.addUser(new Users());
        Assertions.assertEquals("Not added", users);
    }

    @Test
    @DisplayName("Find all users")
    void findAllUsers(){
        String users = getUserService.getAllUsers();

        Assertions.assertEquals("Users found", users);
    }

    @Test
    @DisplayName("User Database is empty")
    void not_findAllUsers(){
        String users = getUserService.getAllUsers();

        Assertions.assertNotEquals("No users found", users);
    }

    @Test
    @DisplayName("Find users by accepted Newsletter")
    void findByNewsLetter(){

        String users = getUserService.getUsersByNewsLetter(true);

        Assertions.assertEquals("Users found", users);
    }

    @Test
    @DisplayName("Don't Find users by accepted Newsletter")
    void not_findByNewsLetter(){

        String users = getUserService.getUsersByNewsLetter(false);

        Assertions.assertEquals("Users not found", users);
    }


    @Test
    @DisplayName("Send emails to NewsLetter")
    void sendMailsToNewsLetter(){

    }



}