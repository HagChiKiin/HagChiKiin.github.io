package inheritance_practice;

import student_management.model.Student;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc =
        Employee[] employees = new Employee[3];
        for (int i = 0; i <employees.length ; i++) {
            employees[i] = studentSevice.createStudent();
        }
        for (Student value: students) {
            studentSevice.printInfo(value);
        }
    }
}
