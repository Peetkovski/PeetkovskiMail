package com.example.mailapp.repository;

import com.example.mailapp.model.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    Iterable<Users> findUsersByNewsletter(Boolean isChecked);

}
