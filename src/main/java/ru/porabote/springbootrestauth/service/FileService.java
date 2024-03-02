package ru.porabote.springbootrestauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.porabote.springbootrestauth.components.FilesComponent;
import ru.porabote.springbootrestauth.components.Logger;
import ru.porabote.springbootrestauth.model.FileModel;
import ru.porabote.springbootrestauth.repository.FileRepository;

import java.io.File;
import java.io.IOException;

@Service
public class FileService {

    @Autowired
    FileRepository fileRepository;
    private String UPLOAD_PATH;

    public FileService() throws IOException {
        fileRepository = fileRepository;
        this.UPLOAD_PATH = new File(".").getCanonicalPath() + "/src/main/storage/uploaded/";
    }

    public FileModel getFile(String filename)
    {
        return fileRepository.findFirstByFilename(filename);
    }

    public FileModel add(@RequestParam MultipartFile file, String filename) throws IOException {
        String dirPath = this.UPLOAD_PATH;
        FilesComponent.makeDirectory(dirPath);
        FilesComponent.makeFile(dirPath + filename);

        File fileTmp = new File(dirPath + filename);
        fileTmp.createNewFile();

        file.transferTo(fileTmp);

        if (fileTmp != null) {
            FileModel f = new FileModel();
            f.setFilename(filename);
            f.setSize(fileTmp.length());
            fileRepository.save(f);
            Logger.write("Загружен файл " + filename);
            return f;
        }

        return null;
    }

    public Boolean delete(String filename) throws IOException {
        String dirPath = this.UPLOAD_PATH;
        fileRepository.deleteByFilename(filename);
        Logger.write("Удален файл " + filename);
        return true;
    }

    public FileModel edit(String oldName, String newName) throws IOException {
        FileModel record = fileRepository.findFirstByFilename(oldName);
        record.setFilename(newName);
        fileRepository.save(record);
        Logger.write("Изменено название файла с " + oldName + "на" + newName);
        return record;
    }

    public Iterable<FileModel> get()
    {
        return fileRepository.findAll();
    }
}
