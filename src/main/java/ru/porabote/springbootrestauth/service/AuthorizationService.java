package ru.porabote.springbootrestauth.service;

import org.apache.el.parser.Token;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.porabote.springbootrestauth.repository.UserRepository;
import ru.porabote.springbootrestauth.service.exception.InvalidCredentials;
import ru.porabote.springbootrestauth.service.exception.UnauthorizedUser;

import java.util.List;

@Service
public class AuthorizationService {
    UserRepository userRepository;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String getAuthorities(Authentication authenticationRequest) throws JSONException {

        String login = authenticationRequest.getName();
        Object credentials = authenticationRequest.getCredentials();
        String password = credentials == null ? null : authenticationRequest.toString();

        if (isEmpty(login) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities = userRepository.getUserAuthorities(login, password);
        if (isEmpty(userAuthorities)) {
            throw new UnauthorizedUser("Unknown user " + login);
        }

        JSONObject jo = new JSONObject();
        jo.put("auth-token", "blabla");
        return "{\"auth-token\": \"blabla\"}";
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}
