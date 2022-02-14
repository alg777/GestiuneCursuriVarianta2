package com.itfactory.data;


import com.itfactory.model.Course;
import com.itfactory.model.Student;
import com.itfactory.utils.DataLoaderUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataLoader {

    private Map<Course, List<Student>> mapCursuri;
    private List<Student> students;

    //constructor
    public DataLoader() {
        mapCursuri = new HashMap<>();
        students = new ArrayList<>();
    }

    public Map<Course, List<Student>> getMapCursuri() {
        return mapCursuri;
    }

    public List<Student> getStudents() {
        return students;
    }


    public void loadData() throws IOException {
        loadCourses();
        loadStudents();
        mapStudentsToCourses();
    }

    private void loadCourses() throws IOException {
        List<String> courseInputData = DataLoaderUtils.readFile(DataLoaderUtils.COURSE_FILE_PATH);

        for (String courseInputDatum : courseInputData) {
            String[] data = courseInputDatum.split(",");
            mapCursuri.put(createCourse(data), new ArrayList<>());
        }
    }

    private Course createCourse(String[] data) {
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double price = Double.parseDouble(data[2]);
        return new Course(id, name, price);
    }

    private void loadStudents() throws IOException {
        List<String> studentInputData = DataLoaderUtils.readFile(DataLoaderUtils.STUDENT_FILE_PATH);

        for (String studentInputDatum : studentInputData) {
            String[] data = studentInputDatum.split(",");
            mapCursuri.put(createStudent(data), new ArrayList<>());
        }
    }

    private Course createStudent(String[] data) {
        int id = Integer.parseInt(data[0]);
        String name = data[1];
        double budget = Double.parseDouble(data[2]);
        return new Course(id, name, budget);
    }

    private void mapStudentsToCourses() throws IOException {
        List<String> mapInputData = DataLoaderUtils.readFile(DataLoaderUtils.MAPPING_FILE_PATH);
        for (String mapInputDatum : mapInputData) {
            String[] map = mapInputDatum.split(",");
//            map[0] = id - ul studentului
//            map[1] = id - ul cursului]
            int idStd = Integer.parseInt(map[0]);
            int idCourse = Integer.parseInt(map[1]);

            Student student = null;
            for (Student student1 : students) {
                if (student1.getStudentId() == idStd) {
                    student = student1;
                    break;
                }
            }
            //la fel imi gasesc cursul dupa id
            //Din map extrag valoarea de la cursul respectiv
            //adica, extrag lista de studenti, care sunt inscrisi la cursul respectiv
            // si adaug studentul in lista

            Course course = null;
            for (Course course1 : mapCursuri.keySet()) {
                if (course1.getCourseId() == idCourse) {
                    course = course1;
                    break;
                }
            }
            mapCursuri.get(course).add(student);
        }
    }

}