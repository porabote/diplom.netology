package ru.porabote.springbootrestauth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.porabote.springbootrestauth.model.UserModel;
import ru.porabote.springbootrestauth.service.Authorities;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    @Transactional
    UserModel findFirstByLoginAndPassword(String login, String password);

}
