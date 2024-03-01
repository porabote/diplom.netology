package ru.porabote.springbootrestauth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.porabote.springbootrestauth.components.FilesComponent;
import ru.porabote.springbootrestauth.model.FileModel;
import ru.porabote.springbootrestauth.repository.FileRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class FileService {

    static String UPLOAD_PATH;

    static {
        try {
            UPLOAD_PATH = new File(".").getCanonicalPath() + "/src/main/storage/uploaded/";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private static FileRepository fileRepository;

    public static FileModel add(@RequestParam MultipartFile file, String filename) throws IOException {
        String dirPath = UPLOAD_PATH;
        FilesComponent.makeDirectory(dirPath);
        FilesComponent.makeFile(dirPath + filename);

        File fileTmp = new File(dirPath + filename);
        fileTmp.createNewFile();

        file.transferTo(fileTmp);

        FileModel f = new FileModel();
        f.setFilename(filename);
        f.setSize(fileTmp.length());
        fileRepository.save(f);

        return f;
    }

    public static Boolean delete(String filename)
    {
        String dirPath = UPLOAD_PATH;
        fileRepository.deleteByFilename(filename);
        return true;
    }

    public static FileModel edit(String oldName, String newName)
    {
        FileModel record = fileRepository.findFirstByFilename(oldName);
        record.setFilename(newName);
        fileRepository.save(record);

        return record;
    }

    public static Iterable<FileModel> get()
    {
        return fileRepository.findAll();
    }
}