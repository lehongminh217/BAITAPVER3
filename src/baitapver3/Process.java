
package baitapver3;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Process {

    public static void main(String[] args) throws ParseException {
        PersonList personList = new PersonList();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n---------------------------------");
            System.out.println("Choose an option:");
            System.out.println("1. Add Student");
            System.out.println("2. Add Teacher");
            System.out.println("3. Update Person (Student/Teacher)");
            System.out.println("4. Delete Person");
            System.out.println("5. Display Everyone");
            System.out.println("6. Find Top Student");
            System.out.println("7. Find Teacher by Department");
            System.out.println("8. Find Person by ID"); // New option for finding a person by ID
            System.out.println("9. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            System.out.println("\n---------------------------------");

            switch (choice) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                    String studentDob = scanner.nextLine();
                    System.out.print("Enter GPA: ");
                    float gpa = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.print("Enter Major: ");
                    String major = scanner.nextLine();
                    personList.addStudent(new Student(studentId, studentName, sdf.parse(studentDob), gpa, major));
                    System.out.println("Student added.");
                    break;

                case 2:
                    System.out.print("Enter Teacher ID: ");
                    String teacherId = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String teacherName = scanner.nextLine();
                    System.out.print("Enter Date of Birth (dd/MM/yyyy): ");
                    String teacherDob = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Teaching Subject: ");
                    String subject = scanner.nextLine();
                    personList.addTeacher(new Teacher(teacherId, teacherName, sdf.parse(teacherDob), department, subject));
                    System.out.println("Teacher added.");
                    break;

                case 3:
                    System.out.print("Enter Person ID to update: ");
                    String updateId = scanner.nextLine();
                    System.out.print("Enter new Full Name: ");
                    String newName = scanner.nextLine();

                    Person person = personList.findPersonById(updateId);
                    if (person != null) {
                        if (person instanceof Student) {
                            System.out.print("Enter new GPA: ");
                            float newGpa = scanner.nextFloat();
                            scanner.nextLine();
                            System.out.print("Enter new Major: ");
                            String newMajor = scanner.nextLine();
                            personList.updatePerson(updateId, newName, newGpa, newMajor);
                        } else if (person instanceof Teacher) {
                            System.out.print("Enter new Date of Birth (dd/MM/yyyy): ");
                            String newTeacherDob = scanner.nextLine();
                            System.out.print("Enter new Department: ");
                            String newDepartment = scanner.nextLine();
                            System.out.print("Enter new Teaching Subject: ");
                            String newSubject = scanner.nextLine();
                            personList.updatePerson(updateId, newName, sdf.parse(newTeacherDob), newDepartment, newSubject);
                        }
                        System.out.println("Person updated.");
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Person ID to delete: ");
                    String deleteId = scanner.nextLine();
                    personList.deletePersonById(deleteId);
                    break;

                case 5:
                    System.out.println("List of all people:");
                    personList.displayEveryone();
                    break;

                case 6:
                    Student topStudent = personList.findTopStudent();
                    if (topStudent != null) {
                        System.out.println("Top student:");
                        topStudent.displayInfo();
                    } else {
                        System.out.println("No students found.");
                    }
                    break;

                case 7:
                    System.out.print("Enter Department: ");
                    String findDepartment = scanner.nextLine();
                    Teacher teacher = personList.findTeacherByDepartment(findDepartment);
                    if (teacher != null) {
                        System.out.println("Teacher found in department " + findDepartment + ":");
                        teacher.displayInfo();
                    } else {
                        System.out.println("No teacher found in that department.");
                    }
                    break;

                case 8: // New case for finding a person by ID
                    System.out.print("Enter Person ID to find: ");
                    String findId = scanner.nextLine();
                    Person foundPerson = personList.findPersonById(findId);
                    if (foundPerson != null) {
                        foundPerson.displayInfo();
                    } else {
                        System.out.println("Person not found.");
                    }
                    break;

                case 9:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            System.out.println("\n---------------------------------");
        }

        scanner.close();
    }
}
