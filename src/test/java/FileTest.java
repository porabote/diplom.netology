import org.junit.jupiter.api.*;
import org.springframework.mock.web.MockMultipartFile;
import ru.porabote.springbootrestauth.controller.FilesController;

import java.io.IOException;

public class FileTest {

    @Test
    public void checkUpload() throws IOException {

        FilesController controller = new FilesController();

        final String fileName = "test.txt";
        final byte[] content = "Hallo Word".getBytes();
        MockMultipartFile mockMultipartFile =
                new MockMultipartFile("content", fileName, "text/plain", content);

        String res = controller.addFile(fileName, mockMultipartFile);
        Assertions.assertEquals(res, "Saved");

    }

    @Test
    public void testEdit() throws IOException {

        FilesController controller = new FilesController();

        final String fileName = "test.txt";
        final byte[] content = "Hallo Word".getBytes();
        MockMultipartFile mockMultipartFile =
                new MockMultipartFile("content", fileName, "text/plain", content);

        String res = controller.addFile(fileName, mockMultipartFile);
        Assertions.assertEquals(res, "Saved");

    }

}
