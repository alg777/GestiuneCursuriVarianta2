package com.itfactory.model;

import java.util.Objects;

public class Student {
    private int studentId;
    private String studentName;
    private double budget;

    public Student(int studentId, String studentName, double budget) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.budget = budget;
    }

    public Student(Student citesteDateCursant) {
    }

    //Getters
    public int getStudentId() {
        return studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public double getBudget() {
        return budget;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentId == student.studentId && Double.compare(student.budget, budget) == 0 && Objects.equals(studentName, student.studentName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(studentId, studentName, budget);
    }

    @Override
    public String toString() {
        return studentId + "," + studentName + "," + budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }

    public void setBudget() {
    }
}
