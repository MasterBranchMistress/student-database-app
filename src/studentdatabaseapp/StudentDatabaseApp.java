package studentdatabaseapp;

import java.util.HashMap;
import java.util.Scanner;

public class StudentDatabaseApp {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        HashMap<String, Student> students = new HashMap<>();

        boolean running = true;

        while (running) {

            System.out.println("\n===== Student Database =====");
            System.out.println("1. Enroll Student");
            System.out.println("2. View All Students");
            System.out.println("3. View Student");
            System.out.println("4. Pay Tuition");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = input.nextInt();
            input.nextLine(); // consume newline

            switch (choice) {

                case 1:

                    Student student = new Student();
                    student.enrollStudent();

                    students.put(student.getStudentId(), student);

                    System.out.println("Student enrolled successfully.");
                    student.displayInfo();
                    break;

                case 2:

                    if (students.isEmpty()) {
                        System.out.println("No students enrolled.");
                    } else {
                        for (Student s : students.values()) {
                            s.displayInfo();
                            System.out.println();
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Student ID: ");
                    String id = input.nextLine();

                    Student found = students.get(id);

                    if (found != null) {
                        found.displayInfo();
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 4:

                    System.out.print("Enter Student ID: ");
                    id = input.nextLine();

                    found = students.get(id);

                    if (found != null) {
                        found.payTuition();
                    } else {
                        System.out.println("Student not found.");
                    }

                    break;

                case 5:

                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:

                    System.out.println("Invalid option.");
            }
        }

        input.close();
    }
}