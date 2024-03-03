package ru.porabote.springbootrestauth.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.junit4.SpringRunner;
import ru.porabote.springbootrestauth.SpringRestApplication;
import ru.porabote.springbootrestauth.model.FileModel;
import ru.porabote.springbootrestauth.service.FileService;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= SpringRestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Controller
public class FileTest {

    @Autowired
    FileService fileService;

    @Test
    public void checkUpload() throws IOException {

        final String fileName = "test.txt";
        final byte[] content = "Hello Word".getBytes();
        MockMultipartFile mockMultipartFile =
                new MockMultipartFile("content", fileName, "text/plain", content);

        FileModel res = fileService.add(mockMultipartFile, fileName);
        Assertions.assertEquals(res, "Saved");

    }

    @Test
    public void testEdit() throws IOException {

        FileService fileService = new FileService();

        final String oldName = "test.txt";
        final String newName = "testRenamed.txt";

        FileModel res = fileService.edit(oldName, newName);
        Assertions.assertEquals(res.getFilename(), newName);

    }

    @Test
    public void testDelete() throws IOException {

        FileService fileService = new FileService();

        final String fileName = "test.txt";

        boolean res = fileService.delete(fileName);
        Assertions.assertTrue(res);

    }

}
