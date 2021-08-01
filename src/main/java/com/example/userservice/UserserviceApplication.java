package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserserviceApplication.class, args);
    }

    // http://localhost:8080/api/login
    // username gabr
    // password 1234


    // http://localhost:8080/api/users
    // Authorization Bearer XXXXX



    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_MANAGER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.save(new User(null, "Gabriel", "gabr",  "1234", new ArrayList<>()));
            userService.save(new User(null, "Testoni", "test", "1234", new ArrayList<>()));

            userService.addRoleToUser("gabr", "ROLE_USER");
            userService.addRoleToUser("test", "ROLE_MANAGER");
            userService.addRoleToUser("test", "ROLE_ADMIN");
            userService.addRoleToUser("test", "ROLE_SUPER_ADMIN");
        };
    }

}
