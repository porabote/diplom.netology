package ru.porabote.springbootrestauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@RestController
@SpringBootApplication
public class SpringRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestApplication.class, args);
    }
}