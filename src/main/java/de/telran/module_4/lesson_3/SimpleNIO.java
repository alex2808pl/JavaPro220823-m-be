package de.telran.module_4.lesson_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.List;

public class SimpleNIO {
    public static void main(String[] args) throws IOException {
        Path path = Paths.get("testFile.txt");
        int nameCount = path.getNameCount();
        System.out.println(nameCount);
        System.out.println(path.toAbsolutePath());

        Path pathDest = Paths.get("copyFile.txt");

        // копирования файла
        Files.copy(path,pathDest, StandardCopyOption.REPLACE_EXISTING);
        // существование файла
        System.out.println( Files.exists(path));

        //Читаем из файла
        List<String> lists = Files.readAllLines(path);
        System.out.println(lists);

        // Запись в файл
        Path outPath = Files.write(pathDest, lists, StandardOpenOption.APPEND);

        //чтение для большийх файлов
        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }

        //запись файлов
        // try с ресурсами, finally выполняется автоматическ, если реализован интерфейс Closable
        try (BufferedWriter writer = Files.newBufferedWriter(pathDest, StandardCharsets.UTF_8,
                StandardOpenOption.APPEND))
        {
            writer.write("Hello World!");
        }

    }


}
