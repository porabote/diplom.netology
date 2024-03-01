import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.multipart.MultipartFile;
import ru.porabote.springbootrestauth.model.FileModel;
import ru.porabote.springbootrestauth.service.FileService;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.rmi.server.RMIServerSocketFactory;
import java.util.stream.Stream;

public class FileTest {

    @Test
    public void checkUpload() throws IOException {

//        String fileName = "unitTest.png";
//        InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);
//        MultipartFile file = new MockMultipartFile("file", fileName, "image/png", inputStream);
//        System.out.println(file);
//        FileModel fileRecord = FileService.add(file, fileName);
//        //assert then
//        Assertions.assertNotNull(fileRecord);

        final String fileName = "test.txt";
        final byte[] content = "Hallo Word".getBytes();
        MockMultipartFile mockMultipartFile =
                new MockMultipartFile("content", fileName, "text/plain", content);

        FileService fileService = new FileService();

        FileModel fileRecord = fileService.add(mockMultipartFile, fileName);

        Assertions.assertNotNull(fileRecord);

    }

}
