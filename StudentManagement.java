package Codsoft;
import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private String name;
    private int rollNumber;
    private String grade;

    public Student(String name, int rollNumber, String grade) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.grade = grade;
    }

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public void setRollNumber(int rollNumber) {
        this.rollNumber = rollNumber;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Student added successfully.");
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
        System.out.println("Student removed successfully.");
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayAllStudents() {
        System.out.println("List of Students:");
        for (Student student : students) {
            System.out.println("Name: " + student.getName() + ", Roll Number: " + student.getRollNumber() +
                    ", Grade: " + student.getGrade());
        }
    }
}

public class StudentManagement {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            StudentManagementSystem system = new StudentManagementSystem();

            while (true) {
                System.out.println("\nStudent Management System Menu:");
                System.out.println("1. Add Student");
                System.out.println("2. Remove Student");
                System.out.println("3. Search for Student");
                System.out.println("4. Display All Students");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();  // Consume newline

                switch (choice) {
                    case 1:
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter roll number: ");
                        int rollNumber = scanner.nextInt();
                        scanner.nextLine();  // Consume newline
                        System.out.print("Enter grade: ");
                        String grade = scanner.nextLine();

                        Student newStudent = new Student(name, rollNumber, grade);
                        system.addStudent(newStudent);
                        break;

                    case 2:
                        System.out.print("Enter roll number of student to remove: ");
                        int removeRollNumber = scanner.nextInt();
                        system.removeStudent(removeRollNumber);
                        break;

                    case 3:
                        System.out.print("Enter roll number of student to search: ");
                        int searchRollNumber = scanner.nextInt();
                        Student searchedStudent = system.searchStudent(searchRollNumber);
                        if (searchedStudent != null) {
                            System.out.println("Student found - Name: " + searchedStudent.getName() +
                                    ", Grade: " + searchedStudent.getGrade());
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;

                    case 4:
                        system.displayAllStudents();
                        break;

                    case 5:
                        System.out.println("Exiting Student Management System. Goodbye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        }
    }
}
