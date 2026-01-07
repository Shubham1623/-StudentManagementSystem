package com.studentapp;

public class Main {
    public static void main(String[] args) {
        // Method execution context: When main() is invoked, a new stack frame is created in the stack memory.
        // This stack frame stores local variables, method parameters, and return addresses.
        // Stack memory follows LIFO (Last In First Out) principle and is managed automatically by JVM.

        System.out.println("============= Student Management System =============");
        System.out.println("============= Welcome =============");

        // Local variable declaration: 's1' is a reference variable stored in the stack memory frame of main().
        // Since Student is a non-primitive (object) type, 's1' will hold a reference (memory address/hash code)
        // pointing to the actual Student object that will be created in the heap memory.
        // Initially, 's1' contains null (default value for reference types) until an object is assigned.
        Student s1;
        
        // Object instantiation process (RHS = Right Hand Side):
        // 1. JVM evaluates the RHS expression first: new Student("Shubham Aggarwal ", 32, "S23-1")
        // 2. If Student class is not already loaded, JVM loads the Student.class file into the Method Area
        // 3. Memory allocation: JVM allocates memory in heap for the Student object (sufficient space for all instance variables)
        // 4. Instance variables initialization: name (String=null), age (int=0), studentId (String=null), courses (List=null)
        // 5. Constructor invocation: Student constructor is called with provided arguments
        // 6. Constructor execution: Validates inputs, initializes instance variables, creates ArrayList for courses
        // 7. Reference assignment: The memory address of the created object is assigned to 's1' in stack memory
        s1 = new Student("Shubham Aggarwal ", 32, "S23-1");
        
        // Method calls: Each enrollCourse() call is added to the stack as a new stack frame.
        // The method validates the course name and adds it to the courses ArrayList if valid and not already present.
        s1.enrollCourse("Java");
        s1.enrollCourse("Test");
        s1.enrollCourse("python");
        
        // toString() method: When printing an object, Java automatically calls the toString() method.
        // If not overridden, it would print the class name and hash code. Since Student overrides toString(),
        // it prints formatted student information (name, age, studentId, courses).
        System.out.println(s1);

        // Creating second Student object: Similar process as above, but creates a separate object in heap memory.
        // 's2' is a different reference variable pointing to a different Student object instance.
        Student s2 = new Student("Richa", 25, "S-2");
        s2.enrollCourse("Java");
        s2.enrollCourse("DSA");
        System.out.println(s2);

        // Creating third Student object: Demonstrates alternative way to display student information.
        Student s3 = new Student("Tushar", 28, "S-3");
        s3.enrollCourse("Java");
        // Using printStudentInfo() instead of toString(): This method provides formatted output with headers,
        // whereas toString() returns a compact string representation suitable for logging or debugging.
        // System.out.println(s3); // Commented out to demonstrate printStudentInfo() method usage
        s3.printStudentInfo();

    }
}