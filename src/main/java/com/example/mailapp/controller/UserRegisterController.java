package com.example.mailapp.controller;

import com.example.mailapp.model.Users;
import com.example.mailapp.service.AddUserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserRegisterController {


    @Autowired
    private AddUserService addUserService;

    @GetMapping("/register")
    public String goToRegisterUserPage(Model model){

        Users users = new Users();

        model.addAttribute("users", users);

        return "register";
    }

    @PostMapping("/registerUser")
    public ResponseEntity<String> registerUser(@RequestBody Users users, Model model){

        addUserService.addUser(users);

        return new ResponseEntity<>("User registered", HttpStatus.OK);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("users")Users users){

        addUserService.addUser(users);


        return "register";
    }



}
