package com.studentapp;

import java.util.*;

public class Main4 {
    private static List<Student> studentList;

    private static Scanner scanner;

    public static void main(String[] args) {
        //Method execution is always happen in stack memory space

        System.out.println("============= Student Management System =============");

        studentList = new ArrayList<>();
        scanner = new Scanner(System.in);
        while (true) {
            System.out.println("============= Welcome =============");
            System.out.println("Select an Option....");
            System.out.println("1. Register a Student");
            System.out.println("2. Find Student with studentId");
            System.out.println("3. List all Student Information");
            System.out.println("4. List Student Information in Sorted Order");
            System.out.println("5. Exit");
            int option = scanner.nextInt();
            scanner.nextLine(); // When we mix next() / nextInt() with nextLine(), we may get empty input.
            //nextInt() reads input
            //Enter (\n) remains in buffer
            //nextLine() immediately consumes that newline...so when calling enrollStudent ...studentName this will not break
            switch (option) {
                case 1:
                    enrollStudent(scanner);
                    break;
                case 2:
                    findStudentById(scanner);
                    break;
                case 3:
                    printAllStudentData();
                    break;
                case 4:
                    sortByName();
                    break;
                case 5:
                    exit();
                    break;
                default:
                    System.out.println("Invalid option selected!....Enter between 1 to 5");
            }
        }

    }

    private static void exit() {
        System.exit(0);
    }

    private static void printAllStudentData() {
        if (!studentList.isEmpty()) {
            System.out.println("--------Printing All Student Data-----------------");
            for (Student student : studentList) {
                student.printStudentInfo();
            }
        } else {
            System.err.println("Student List is empty");
        }
    }

    private static void enrollStudent(Scanner scanner) {
        System.out.println("Enter Student Name");
        String studentName = scanner.nextLine();
        System.out.println("Enter Student Age");
        int studentAge = scanner.nextInt();

        System.out.println("Enter Student Id");
        String studentId = scanner.next();

        Student newStudent = new Student(studentName, studentAge, studentId);
        studentList.add(newStudent);

        while (true) {
            System.out.println("Enter the course to be enrolled!!.....Type done to exit");
            String courseName = scanner.next();
            if (courseName.equalsIgnoreCase("done")) {
                break;
            }
            newStudent.enrollCourse(courseName);
        }
        System.out.println("Student enrolled to the course");

        newStudent.printStudentInfo();

    }

    private static void findStudentById(Scanner scanner) {
        Student result = null;
        System.out.println("Enter the student ID");
        String studentId = scanner.next();
        try {
            result = studentList.
                    stream().filter(student -> student.getStudentId().equalsIgnoreCase(studentId))
                    .findFirst().orElseThrow(() -> new RuntimeException("No Data Found!!!"));
        } catch (RuntimeException ex) {
            System.err.println("Student with ID [" + studentId + "] not found.");
        }
        result.printStudentInfo();
    }

    private static void sortByName() {
        Comparator<Student> studentNameComparator = (o1, o2) -> o1.getName().compareTo(o2.getName());

        Collections.sort(studentList, studentNameComparator);
        printAllStudentData();
    }

}