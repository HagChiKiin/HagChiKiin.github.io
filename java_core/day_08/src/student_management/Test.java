package student_management;

import student_management.model.Student;
import student_management.sevice.StudentSevice;

public class Test {
    public static void main(String[] args) {
        StudentSevice studentSevice = new StudentSevice();
        Student student = studentSevice.createStudent();// dùng biến kiểu student để hứng dữ liệu trả về
        studentSevice.printInfo(student);// truyền dữ liệu
        // Nhập nhiều đối tượng student
        Student [] students = new Student[3];
        for (int i = 0; i <students.length ; i++) {
            students[i] = studentSevice.createStudent();
        }
        for (Student value: students) {
            studentSevice.printInfo(value);
        }

    }
}
