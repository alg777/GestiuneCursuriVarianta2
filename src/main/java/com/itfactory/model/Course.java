package com.itfactory.model;

import java.util.Objects;

public class Course {
    private int courseId;
    private String courseName;
    private double price;

    public Course(int courseId, String courseName, double price) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.price = price;
    }

    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return courseId == course.courseId && Double.compare(course.price, price) == 0 && Objects.equals(courseName, course.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, courseName, price);
    }

    @Override
    public String toString() {
        return courseId + "," + courseName + "," + price;
    }
}
