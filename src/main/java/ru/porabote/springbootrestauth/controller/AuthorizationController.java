package ru.porabote.springbootrestauth.controller;

import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.porabote.springbootrestauth.model.UserModel;
import ru.porabote.springbootrestauth.service.AuthorizationService;
import java.util.Map;

@RestController
public class AuthorizationController {

    private final AuthorizationService authorizationService;

    public AuthorizationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestBody Map<String, String> payload) throws JSONException {

        String login = payload.get("login");
        String password = payload.get("password");

        Authentication authenticationRequest =
                UsernamePasswordAuthenticationToken.unauthenticated(login, password);

        UserModel user = this.authorizationService.getAuthorities(authenticationRequest);

        String token = "{\"auth-token\": \"" + "some_token" + "\"}";
        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

    public record LoginRequest(String username, String password) {
    }

}
