package com.example.mailapp.service;

import com.example.mailapp.model.Users;
import com.example.mailapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetUserService {

    @Autowired
    private UserRepository userRepository;


    public String getAllUsers(){



        Iterable<Users> user = userRepository.findAll();

        if(!user.equals(null)) {

            System.out.println(user);
            return "Users found";
        }
        else {

            return "No users found";
        }

    }

    public String getUsersByNewsLetter(Boolean isAccepted){
        Iterable<Users> users = userRepository.findUsersByNewsletter(isAccepted);

        if(isAccepted==true){
            System.out.println(users);
            return "Users found";
        }
        else{
            return "Users not found";
        }
    }

}
