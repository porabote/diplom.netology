package ru.porabote.springbootrestauth.repository;

import org.springframework.stereotype.Repository;
import ru.porabote.springbootrestauth.service.Authorities;

import java.util.Arrays;
import java.util.List;

import static ru.porabote.springbootrestauth.service.Authorities.*;

@Repository
public class UserRepository {

    public List<Authorities> getUserAuthorities(String user, String password) {
        return Arrays.asList(READ, WRITE, DELETE);
    }

}
