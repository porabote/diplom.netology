package ru.porabote.springbootrestauth.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.porabote.springbootrestauth.model.FileModel;
import ru.porabote.springbootrestauth.model.UserModel;

import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface FileRepository extends CrudRepository<FileModel, Integer> {

    @Transactional
    Long deleteByFilename(String filename);

    @Transactional
    FileModel findFirstByFilename(String filename);

}