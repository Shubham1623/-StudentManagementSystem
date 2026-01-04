package com.studentapp;

public class Main {
    public static void main(String[] args) {
        //Method execution is always happen in stack memory space

        System.out.println("============= Student Management System =============");
        System.out.println("============= Welcome =============");

        // below is the local variable which gets stored in stack memory
        Student s1;   //as its Non-Primitive data type so its a reference variable which stores the unique identification or hash code of the object created in heap memory
        s1= new Student("Shubham Aggarwal ", 32, "S23-1");          // Java solves RHS first
        // Student class will be loaded into the memory
        // 4 instance variable will be created inside heap memory space
        // Constructor is getting called
        s1.enrollCourse("Java");
        s1.enrollCourse("Test");
        s1.enrollCourse("python");
        System.out.println(s1);

        Student s2 = new Student("Richa",25,"S-2");
        s2.enrollCourse("Java");
        s2.enrollCourse("DSA");
        System.out.println(s2);

        Student s3 = new Student("Tushar",28,"S-3");
        s3  .enrollCourse("Java");
//        System.out.println(s3);
        s3.printStudentInfo();

    }
}