package com.studentapp;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

    //instance variable should be marked as private
    private String name;   // non-primitive data type so default value is null
    private int age;       // default value is 0
    private String studentId;  //default value is null
    private List<String> courses; //default value is null


    public Student(String name, int age, String studentId) { // arguments are the local variable
        //this is used to diffrentiate between local and instance variable
        if (validateAge(age) && vaildateName(name) && validateStudentId(studentId)) {
            this.name = name;
            this.age = age;
            this.studentId = studentId;
            courses = new ArrayList<>();
        }// As List is an interface and can be implemented by ArrayList  (Initializing here)
    }


    public void enrollCourse(String course) {
        if(validateCourseName(course)) {
            if (!courses.contains(course)) {
                courses.add(course);
                System.out.println("Student is enrolled to " + course + " successfully!!");

            } else {
                System.err.println("Student is already enrolled for the course " + course);
            }
        }
    }

    public void printStudentInfo() {
        System.out.println("=============== Student Information ===============");
        System.out.println("Student Name: " + name);
        System.out.println("Student Age: " + age);
        System.out.println("Student Id: " + studentId);
        System.out.println("Enrolled for: " + courses);

    }

    //validation method
    public boolean validateAge(int age) {
        if (age >= 19 && age < 35) {
            return true;
        } else {
            System.err.println("Invalid age !! Student age needs to be between 19 and 35");
            return false;
        }
    }

    public boolean vaildateName(String name) {
        String nameRagex = "^[a-zA-Z\\s]+$"; // ^ sign means it should start with an alphabet
        // \\ this mean a white space, + is n number of combination , $ end with an alphabet or a space
        Pattern namePattern = Pattern.compile(nameRagex);
        Matcher nameMatcher = namePattern.matcher(name);
        if (nameMatcher.matches()) {
            return true;
        } else {
            System.err.println("Invalid Name !! Please enter alphabets only");
            return false;
        }
    }

    private boolean validateStudentId(String studentId) {
        String studentIdRegex = "S-[0-9]+$";  //or "S-\\d+$"; \\d is digit
        Pattern studentIdPattern = Pattern.compile(studentIdRegex);
        Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
        if (studentIdMatcher.matches()) {
            return true;
        } else {
            System.err.println("Invalid Student Id... use the format... Eg. S-123");
            return false;
        }
    }

    public boolean validateCourseName(String course)
    {
        if(course.equalsIgnoreCase("JAVA")||course.equalsIgnoreCase("DSA")||course.equalsIgnoreCase("Python"))
        {
            return true;
        }
        else
        {
            System.err.println("Invalid Course Name !!! Please select courses from the list [Java, DSA, Python]");
            return false;
        }
    }

    // below is one of the way to print the Student information (This by default will print when calling like sout(s1))
    // if this is not there then while doing sout(s1)...the reference variable hash code will be printed
    @Override
    public String toString() {
        return "Student [" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", studentId='" + studentId + '\'' +
                ", courses=" + courses +
                ']';
    }

    public List<String> getCourses() {
        return courses;
    }

    public String getStudentId() {
        return studentId;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }
}
