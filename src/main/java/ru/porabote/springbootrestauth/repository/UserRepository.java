package ru.porabote.springbootrestauth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.porabote.springbootrestauth.model.UserModel;

@Repository
public interface UserRepository extends CrudRepository<UserModel, Integer> {

    @Transactional
    UserModel findFirstByUsername(String username);

    @Transactional
    UserModel findByUsername(String userName);
}
