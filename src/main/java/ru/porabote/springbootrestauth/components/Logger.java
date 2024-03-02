package ru.porabote.springbootrestauth.components;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

    private static String FILE_LOG_PATH = "/src/main/storage/logs/log.txt";

    public static void write(String log) throws IOException {
        String path = new File(".").getCanonicalPath() + FILE_LOG_PATH;

        BufferedWriter writer = new BufferedWriter(new FileWriter(path));
        writer.write(log);

        writer.close();
    }

}
