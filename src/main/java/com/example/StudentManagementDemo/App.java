package com.example.StudentManagementDemo;

import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {

            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {

            case 1:

                System.out.print("Enter Student ID: ");
                int id = sc.nextInt();
                sc.nextLine();

                System.out.print("Enter Student Name: ");
                String name = sc.nextLine();

                System.out.print("Enter Email: ");
                String email = sc.nextLine();

                System.out.print("Enter Course: ");
                String course = sc.nextLine();

                System.out.print("Enter Age: ");
                int age = sc.nextInt();

                Student student =
                        new Student(id, name, email, course, age);

                dao.saveStudent(student);

                System.out.println("Student Added Successfully!");
                break;

            case 2:

                List<Student> students = dao.getAllStudents();

                for (Student s : students) {
                    System.out.println(
                            s.getStudentId() + " | " +
                            s.getStudentName() + " | " +
                            s.getEmail() + " | " +
                            s.getCourse() + " | " +
                            s.getAge());
                }

                break;

            case 3:

                System.out.print("Enter Student ID: ");
                int searchId = sc.nextInt();

                Student s = dao.getStudentById(searchId);

                if (s != null) {
                    System.out.println("ID: " + s.getStudentId());
                    System.out.println("Name: " + s.getStudentName());
                    System.out.println("Email: " + s.getEmail());
                    System.out.println("Course: " + s.getCourse());
                    System.out.println("Age: " + s.getAge());
                } else {
                    System.out.println("Student Not Found!");
                }

                break;

            case 4:

                System.out.print("Enter Student ID to Update: ");
                int updateId = sc.nextInt();
                sc.nextLine();

                Student updateStudent =
                        dao.getStudentById(updateId);

                if (updateStudent != null) {

                    System.out.print("Enter New Name: ");
                    updateStudent.setStudentName(sc.nextLine());

                    System.out.print("Enter New Email: ");
                    updateStudent.setEmail(sc.nextLine());

                    System.out.print("Enter New Course: ");
                    updateStudent.setCourse(sc.nextLine());

                    System.out.print("Enter New Age: ");
                    updateStudent.setAge(sc.nextInt());

                    dao.updateStudent(updateStudent);

                    System.out.println("Student Updated Successfully!");
                } else {
                    System.out.println("Student Not Found!");
                }

                break;

            case 5:

                System.out.print("Enter Student ID to Delete: ");
                int deleteId = sc.nextInt();

                dao.deleteStudent(deleteId);

                System.out.println("Student Deleted Successfully!");
                break;

            case 6:

                System.out.println("Exiting...");
                sc.close();
                System.exit(0);

            default:
                System.out.println("Invalid Choice!");
            }
        }
    }
}