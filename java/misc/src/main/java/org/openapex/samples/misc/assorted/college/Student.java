package org.openapex.samples.misc.assorted.college;

import java.util.List;

public class Student {
    private String firstName ;
    private String lastName ;
    private String telephone ;
    private String address ;
    private String department ;
    private int age ;
    private List<Course> courses ;
    public Student(String firstName,String lastName,String       telephone,String address,int age) {
        this.firstName = firstName ;
        this.lastName = lastName ;
        this.address = address ;
        this.age = age ;
        this.telephone = telephone;
        department = null ;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFullName() {
        return firstName+lastName;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getAddress() {
        return address;
    }
    public String getDepartment() {
        return department;
    }

    public int getAge() {
        return age;
    }

    public List<Course> getCourses() {
        return courses;
    }

    // methods
    String fullName(String firstName,String lastName ) {
        this.firstName =firstName ;
        this.lastName = lastName;
        return firstName +firstName ;
    }

}
