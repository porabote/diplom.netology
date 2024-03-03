package ru.porabote.springbootrestauth.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.porabote.springbootrestauth.model.FileModel;

@Repository
public interface FileRepository extends CrudRepository<FileModel, Integer> {

    @Transactional
    void deleteByFilename(String filename);

    @Transactional
    FileModel findFirstByFilename(String filename);

}