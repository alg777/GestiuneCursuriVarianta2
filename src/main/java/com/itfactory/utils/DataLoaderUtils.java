package com.itfactory.utils;

import com.itfactory.model.Course;
import com.itfactory.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLoaderUtils {
    public static Map<Course, List<Student>> mapCursuri = new HashMap<>();
    public static List<Student> studentList;


    public static final String COURSE_FILE_PATH = "cursuri.csv";
    public static final String STUDENT_FILE_PATH = "studenti.csv";
    public static final String MAPPING_FILE_PATH = "mapari.csv";

    public static List<String> readFile(String filePathStr) throws IOException {
        Path path = Paths.get(filePathStr);
        try {
            List<String> liniiDinFisier = Files.readAllLines(path);
            System.out.println(liniiDinFisier);
        } catch (IOException e) {
            System.out.println("Fisierul nu exista");
            e.printStackTrace();
        }
        return Files.readAllLines(path);
    }
}