package studentdatabaseapp;

import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Student {

    private static final Scanner input = new Scanner(System.in);

    private String firstName;
    private String lastName;
    private int year;
    private String studentId;
    private HashMap<String, String> courses = new HashMap<>();
    private int tuitionBalance;

    public Student() {
    }

    private void addToTuitionBalance() {
        tuitionBalance += 600;
    }

    private String generateStudentId(int length) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(ThreadLocalRandom.current().nextInt(10));
        }

        return year + sb.toString();
    }

    public void payTuition() {

        System.out.println("Current Balance: $" + tuitionBalance);
        System.out.print("Payment Amount: ");

        int payment = input.nextInt();
        input.nextLine();

        if (payment <= 0) {
            System.out.println("Invalid payment.");
            return;
        }

        tuitionBalance = Math.max(0, tuitionBalance - payment);

        System.out.println("Payment received.");
        System.out.println("Remaining Balance: $" + tuitionBalance);
    }

    public void enrollStudent() {

        System.out.print("Student First Name: ");
        firstName = input.nextLine();

        System.out.print("Student Last Name: ");
        lastName = input.nextLine();

        System.out.print("Student Year (1-4): ");
        year = input.nextInt();
        input.nextLine(); // consume newline

        studentId = generateStudentId(5);

        int choice = -1;

        while (choice != 0) {

            System.out.println();
            System.out.println("Choose a class:");
            System.out.println("1. History");
            System.out.println("2. Mathematics");
            System.out.println("3. English");
            System.out.println("4. Chemistry");
            System.out.println("5. Computer Science");
            System.out.println("0. Finish");

            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:
                    courses.put("HIST101", "History");
                    addToTuitionBalance();
                    System.out.println("History added.");
                    break;

                case 2:
                    courses.put("MATH101", "Mathematics");
                    addToTuitionBalance();
                    System.out.println("Mathematics added.");
                    break;

                case 3:
                    courses.put("ENG101", "English");
                    addToTuitionBalance();
                    System.out.println("English added.");
                    break;

                case 4:
                    courses.put("CHEM101", "Chemistry");
                    addToTuitionBalance();
                    System.out.println("Chemistry added.");
                    break;

                case 5:
                    courses.put("COMPSCI101", "Computer Science");
                    addToTuitionBalance();
                    System.out.println("Computer Science added.");
                    break;

                case 0:
                    System.out.println("Enrollment complete.");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
    }

    public void displayInfo() {

        System.out.println("\nStudent Information");
        System.out.println("------------------------");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Year: " + year);
        System.out.println("Student ID: " + studentId);
        System.out.println("Courses: " + courses.values());
        System.out.println("Balance: $" + tuitionBalance);
    }

    public String getStudentId() {
        return studentId;
    }

    public int getBalance() {
        return tuitionBalance;
    }
}