package com.itfactory.data;

import com.itfactory.model.Course;
import com.itfactory.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DataSaver {
    private void saveCourses(Map<Course, List<Student>> map) {
        Set<Course> set = map.keySet();
        String dateCursuri = "";
        for (Course course : set) {
            dateCursuri = dateCursuri.concat(course.toString().concat("\n"));
        }
    }

    //la fel ca sus, saveCourses
    private void saveStudents(Map<Course, List<Student>> map) {

        for (List<Student> valoriDinMap : map.values()) {
            String dateStudent="";
            for (Student student : valoriDinMap) {
                //..folosim metoda toString pentru a extrage datele
            dateStudent = dateStudent.concat(student.toString().concat("\n"));
            }
        }
    }

    private void saveMapping(Map<Course, List<Student>> map) {
        String mapari = "";
        for (Map.Entry<Course, List<Student>> entry : map.entrySet()) {
            int courseId = entry.getKey().getCourseId();
            for (Student student : entry.getValue()) {
                int studentId = student.getStudentId();
                //se va crea o mapare
                mapari = mapari.concat(String.valueOf(studentId).concat(",").concat(String.valueOf(courseId)).concat("\n"));
            }
        }

    }

    public void saveData(Map<Course, List<Student>> map) {

    }
}
