package ru.otus.spring2018.lesson1.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVUtils {
    public static List<String[]> getDataFromCsv(String fileName) {
        List<String[]> data = new ArrayList<>();
        try {
            ClassPathResource classPathResource = new ClassPathResource(fileName);
            File file = classPathResource.getFile();
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
               data.add(scanner.nextLine().split(","));
            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
