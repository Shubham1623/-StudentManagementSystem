package com.studentapp;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    private static List<Student> studentList;

    public static void main(String[] args) {
        //Method execution is always happen in stack memory space

        System.out.println("============= Student Management System =============");
        System.out.println("============= Welcome =============");

        studentList = new ArrayList<>();

        Student s1;
        s1 = new Student("Shubham Aggarwal ", 32, "S-1");
        s1.enrollCourse("Java");
        s1.enrollCourse("Test");
        s1.enrollCourse("python");

        Student s2 = new Student("Richa", 25, "S-2");
        s2.enrollCourse("Java");
        s2.enrollCourse("DSA");

        Student s3 = new Student("Tushar", 28, "S-3");
        s3.enrollCourse("Java");

        studentList.add(s1);
        studentList.add(s2);
        studentList.add(s3);
        //here each arraylist item is just storing the reference of variable present in the heap memory

        Student result = findStudentById("S-2");
        System.out.println("Result " + result);
    }

    public static Student findStudentById(String studentId) {
        Student result = null;
        try {
            result = studentList
                    .stream()
                    .filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("No Data Found!!!"));
        }
        catch (RuntimeException ex)
        {
            System.err.println("Student with ID ["+studentId+"] not found.");
        }
        return result;
    }

}