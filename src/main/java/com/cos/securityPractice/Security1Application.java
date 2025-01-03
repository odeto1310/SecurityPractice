package com.cos.securityPractice;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.UserDetailsManager;

@SpringBootApplication
public class Security1Application {

    public static void main(String[] args) {
        SpringApplication.run(Security1Application.class, args);
    }

}
