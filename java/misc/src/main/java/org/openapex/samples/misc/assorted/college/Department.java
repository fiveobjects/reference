package org.openapex.samples.misc.assorted.college;

import java.util.ArrayList;
import java.util.List;

public class Department {
    public String name;
    public String description;
    public int max_number_of_students;
    public List<Course> courses;
    public List<Student> students;

    public Department(String name, String description, int max_number_of_students) {
        this.name = name;
        this.description = description;
        this.max_number_of_students = max_number_of_students;
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getMax_number_of_students() {
        return max_number_of_students;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public List<Student> getStudents() {
        return students;
    }

    void enroll(Student s) {
        students.add(s);
    }
}
