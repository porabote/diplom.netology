package ru.porabote.springbootrestauth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import ru.porabote.springbootrestauth.model.FileModel;

public interface FileRepository extends CrudRepository<FileModel, Integer> {

    @Transactional
    void deleteByFilename(String filename);

    @Transactional
    FileModel findFirstByFilename(String filename);

}