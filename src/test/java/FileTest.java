import org.junit.jupiter.api.*;
import org.springframework.mock.web.MockMultipartFile;
import ru.porabote.springbootrestauth.controller.FilesController;
import ru.porabote.springbootrestauth.model.FileModel;
import ru.porabote.springbootrestauth.service.FileService;

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

        FileService service = new FileService();

        final String oldName = "test.txt";
        final String newName = "testRenamed.txt";

        FileModel res = service.edit(oldName, newName);
        Assertions.assertEquals(res.getFilename(), newName);

    }

    @Test
    public void testDelete() throws IOException {

        FileService service = new FileService();

        final String fileName = "test.txt";

        boolean res = service.delete(fileName);
        Assertions.assertTrue(res);

    }

}
