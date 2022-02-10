package com.example.mailapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    @GeneratedValue()
    private Long id;
    private String name;
    private String surname;
    private String password;
    private String email;
    private Integer age;
    private LocalDate localDate;
    private LocalTime localTime;
    private Boolean newsletter;

}
