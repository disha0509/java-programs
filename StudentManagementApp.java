import java.util.ArrayList;
import java.util.List;
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

    public String getName() {
        return name;
    }

    public int getRollNumber() {
        return rollNumber;
    }

    public String getGrade() {
        return grade;
    }
}

class StudentManagementSystem {
    private List<Student> students;

    public StudentManagementSystem() {
        students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void removeStudent(int rollNumber) {
        students.removeIf(student -> student.getRollNumber() == rollNumber);
    }

    public Student searchStudent(int rollNumber) {
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                return student;
            }
        }
        return null;
    }

    public void displayStudents() {
        for (Student student : students) {
            System.out.println("Name: " + student.getName() +
                               " | Roll Number: " + student.getRollNumber() +
                               " | Grade: " + student.getGrade());
        }
    }

    // Other methods like read/write to storage, edit student, etc.
    // ...
}

public class StudentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentManagementSystem system = new StudentManagementSystem();

        while (true) {
            System.out.println("\nStudent Management System");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display Students");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    addStudent(scanner, system);
                    break;
                case 2:
                    removeStudent(scanner, system);
                    break;
                case 3:
                    searchStudent(scanner, system);
                    break;
                case 4:
                    displayStudents(system);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static void addStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine(); // Consume the newline
        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        system.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = scanner.nextInt();
        system.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }

    private static void searchStudent(Scanner scanner, StudentManagementSystem system) {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = scanner.nextInt();
        Student student = system.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found:");
            System.out.println("Name: " + student.getName() +
                               " | Roll Number: " + student.getRollNumber() +
                               " | Grade: " + student.getGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    private static void displayStudents(StudentManagementSystem system) {
        System.out.println("Students:");
        system.displayStudents();
    }
}
