package ru.porabote.springbootrestauth.service;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import ru.porabote.springbootrestauth.model.UserModel;
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

    public String getAuthorities(Authentication authenticationRequest) {

        String login = authenticationRequest.getName();
        Object credentials = authenticationRequest.getCredentials();
        String password = credentials == null ? null : authenticationRequest.toString();

        if (isEmpty(login) || isEmpty(password)) {
            throw new InvalidCredentials("User name or password is empty");
        }
//        List<Authorities> userAuthorities = userRepository.getUserAuthorities(login, password);
//        if (isEmpty(userAuthorities)) {
//            throw new UnauthorizedUser("Unknown user " + login);
//        }

        UserModel user = userRepository.findFirstByLogin(login);
        System.out.println(user.getToken());
        if (user == null) {
            throw new UnauthorizedUser("Unknown user " + login + password);
        }
        return "{\"auth-token\": \"" + user.getToken() + "\"}";
    }

    private boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }

    private boolean isEmpty(List<?> str) {
        return str == null || str.isEmpty();
    }


}
