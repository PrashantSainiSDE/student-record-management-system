package com.srms.app;

import java.util.ArrayList;

import java.util.Scanner;

public class StudentRecords {

    public static void addStudent(ArrayList<Student> students, Scanner sc) {
        int id = getIntegerInput(sc, "Enter student ID:");

        Student studentById = findStudentById(students, id);
        if (studentById != null) {
            System.out.println("Error: Student with the given ID already exists!");
            return;
        }

        System.out.print("Enter student name:");
        String name = sc.nextLine().trim();

        // Validate empty name
        while (name.isEmpty()) {
            System.out.println("Error: Name cannot be empty!");
            System.out.print("Enter student name: ");
            name = sc.nextLine().trim();
        }

        int marks;
        while (true) {
            marks = getIntegerInput(sc, "Enter student marks: ");
            if (marks < 0) {
                System.out.println("Error: Marks must be a positive number!");
            } else {
                break;
            }
        }


        students.add(new Student(id, name, marks));
        System.out.println("Success: Student added successfully!");
    }

    // Update student record
    public static void updateStudent(ArrayList<Student> students, Scanner sc) {
        if (students.isEmpty()) {
            System.out.println("Info: No records available to update!");
            return;
        }
        int id = getIntegerInput(sc, "Enter student ID to update: ");
        Student target = findStudentById(students, id);

        if (target == null) {
            System.out.println("Info: Student not found with the given ID!");
            return;
        }

        System.out.print("Enter new name (leave blank to keep unchanged): ");
        String newName = sc.nextLine().trim();

        if (!newName.isBlank()) {
            target.setName(newName.trim());
        }

        System.out.print("Enter new marks (or press Enter to keep unchanged): ");
        String marksInput = sc.nextLine().trim();

        if (!marksInput.isEmpty()) {
            try {
                int newMarks = Integer.parseInt(marksInput);
                if (newMarks < 0) {
                    throw new NumberFormatException("Error: Marks must be a positive number!");
                }
                target.setMarks(newMarks);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid marks input — keeping previous marks.");
            }
        }

        System.out.println("Success: Student record updated successfully!\n");
    }

    // Delete student record
    public static void deleteStudent(ArrayList<Student> students, Scanner sc) {
        if (students.isEmpty()) {
            System.out.println("Info: No student records to delete!");
            return;
        }

        int id = getIntegerInput(sc, "Enter student ID to delete: ");

        Student toRemove = findStudentById(students, id);

        if (toRemove == null) {
            System.out.println("Info: Student not found with the given ID!");
            return;
        }

        students.remove(toRemove);
        System.out.println("Success: Student deleted successfully!\n");
    }

    public static Student findStudentById(ArrayList<Student> students, int id) {

        return students.stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
    }

    // Display all students
    public static void displayStudents(ArrayList<Student> students) {
        if (students.isEmpty()) {
            System.out.println("️Info: No student records found!");
            return;
        }

        System.out.println("\n------------- Student Records --------------------");
        System.out.printf("%-10s %-20s %-10s%n", "ID", "Name", "Marks");
        for (Student s : students) {
            System.out.printf("%-10d %-20s %-10d%n", s.getId(), s.getName(), s.getMarks());
        }
        System.out.println("--------------------------------------------------\n");
    }

    public static int getIntegerInput(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();

            try {
                if (input.isEmpty()) {
                    throw new NumberFormatException("Error: Input cannot be empty!");
                }
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid number! Please enter a valid numeric value.");
            }
        }
    }

    public static int getMenuChoice(Scanner sc) {
        while (true) {
            System.out.println("Please select an operation:");
            System.out.println("1. Add new student");
            System.out.println("2. Update student details");
            System.out.println("3. Remove student");
            System.out.println("4. Display all students");
            System.out.println("5. Exit");
            System.out.print("Enter choice (1-5): ");

            String input = sc.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                if (choice < 1 || choice > 5) {
                    throw new IllegalArgumentException("Error: Choice must be between 1 and 5.");
                }
                return choice;
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input! Please enter a number between 1 and 5.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(101, "Prince", 460));

        Scanner sc = new Scanner(System.in);

        System.out.println("--------- Student Record Management System ---------");

        while (true) {
            int choice = getMenuChoice(sc);

            if (choice == 5) {
                System.out.println("Shutting down system. Goodbye!");
                sc.close();
                break;
            }

            switch (choice) {
                case 1 -> addStudent(students, sc);
                case 2 -> updateStudent(students, sc);
                case 3 -> deleteStudent(students, sc);
                case 4 -> displayStudents(students);
                default -> System.out.println("Invalid choice!");
            }

            System.out.println("Press Enter to continue...");
            sc.nextLine();
        }
    }
}

