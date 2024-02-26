package ru.porabote.springbootrestauth.controller;

import com.google.gson.Gson;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.porabote.springbootrestauth.service.Authorities;
import ru.porabote.springbootrestauth.service.AuthorizationService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class AuthorizationController {

    AuthorizationService service;

    private Gson gson = new Gson();

    public AuthorizationController(AuthorizationService service) {
        this.service = service;
    }

    @GetMapping("/authorize")
    public List<Authorities> getAuthorities(@RequestParam("login") String user, @RequestParam("password") String password) {
        return service.getAuthorities(user, password);
    }

}
