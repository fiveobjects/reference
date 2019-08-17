package org.openapex.samples.misc.assorted.college;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollegeSystem {

    public static void printOptions() {
        System.out.println("Welcome to our university!");
        System.out.println("Operations:");
        System.out.println("1- College");
        System.out.println("a) Number of Departments");
        System.out.println("b) Number of Courses");
        System.out.println("c) Number of Professors");
        System.out.println("d) Number of Students");
        System.out.println("e) Report");
        System.out.println("2- Department");
        System.out.println("a) New");
        System.out.println("b) Number of Courses");
        System.out.println("c) Number of Students");
        System.out.println("d) Is Full");
        System.out.println("e) Enroll");
        System.out.println("f) Report");
        System.out.println("3- Course");
        System.out.println("a) New");
        System.out.println("b) Number of Students");
        System.out.println("c) Assign");
        System.out.println("d) Is assigned");
        System.out.println("e) Professor Name");
        System.out.println("f) Is Full");
        System.out.println("g) Enroll");
        System.out.println("h) Report");
        System.out.println("4- Professor");
        System.out.println("a) New");
        System.out.println("b) Display Salary");
        System.out.println("c) Get Raise");
        System.out.println("d) Report");
        System.out.println("5- Student");
        System.out.println("a) New");
        System.out.println("b) Report");
        System.out.println("6- Quit");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        printOptions();
        List<Department> departmentList;
        departmentList = new ArrayList<>();
        List<Course> courseList;
        courseList = new ArrayList<>();
        List<Professor> proffList = new ArrayList<>();
        List<Student> studentList;
        studentList = new ArrayList<>();


        Scanner in = new Scanner(System.in);
        int d = 0, c = 0, p = 0, s = 0;
        College AinShams = new College();
        while (true) {

            String option = in.nextLine();
            if (!"6".equals(option)) {
                if ("2a".equalsIgnoreCase(option)) { // Define new department
                    System.out.println("Department Name:");
                    String depName = "";
                    depName = in.nextLine();
                    System.out.println("Department Description:");
                    String depDescripe = in.nextLine();
                    System.out.println("Department Max Students:");
                    int max_num = in.nextInt();
                    in.nextLine();
                    Department Department_Name = new Department(depName, depDescripe, max_num);

                    departmentList.add(d, Department_Name);
                    d++;
                    AinShams.setDepart(departmentList);

                } else if ("5a".equalsIgnoreCase(option)) { // create new student
                    System.out.println("Student Firstname:");
                    String firstName = "";
                    firstName = in.nextLine();
                    System.out.println("Student Lastname:");
                    String lastName = "";
                    lastName = in.nextLine();
                    System.out.println("Student telephone:");
                    String telephone = in.nextLine();
                    System.out.println("Student address:");
                    String address = in.nextLine();
                    System.out.println("Student Age:");
                    int age = in.nextInt();
                    in.nextLine();
                    Student stud = new Student(firstName, lastName, telephone, address, age);
                    studentList.add(s, stud);
                    s++;
                    AinShams.setStudent(studentList);

                } else if ("2e".equalsIgnoreCase(option)) {//add student in department
                    System.out.println("Department:");
                    String dep = in.nextLine();
                    System.out.println("Student:");
                    String stu = in.nextLine();
                    for (int i = 0; i < AinShams.getDepart().size(); i++) {
                        //  System.out.println("1st for loop");
                        System.out.println(dep + " " + AinShams.getDepart().get(i).getName());
                        if (dep.equals(AinShams.getDepart().get(i).getName())) {
                            // System.out.println("1st if condition");
                            for (int j = 0; j < AinShams.getStudent().size(); j++) {
                                //  System.out.println("2nd for loop");
                                if (stu.equals(AinShams.getStudent().get(j).getFullName())) {
                                    // System.out.println("2nd if condition");
                                    AinShams.getDepart().get(i).enroll(AinShams.getStudent().get(j));
                                }
                            }
                        }

                    }
                }

                System.out.println("============");
                System.out.println("Enter Operation");
                System.out.println("============");
            } else {
                break;
            }

        }
    }
}