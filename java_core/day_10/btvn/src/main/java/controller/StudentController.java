package controller;

import model.Student;
import service.StudentService;

import java.util.Scanner;

public class StudentController {
    StudentService studentService = new StudentService();

    public void runMenu() {
        Scanner sc = new Scanner(System.in);
        boolean isQuit = false;

        while (!isQuit) {
            showMenu();
            System.out.print("Nhập lựa chọn : ");
            int option = Integer.parseInt(sc.nextLine());

            switch (option) {
                case 1:
                    studentService.showAllStudent();
                    break;
                case 2:
                    System.out.print("Id: ");
                    int id = Integer.parseInt(sc.nextLine());

                    System.out.print("Tên: ");
                    String name = sc.nextLine();

                    System.out.print("Tuổi: ");
                    int age = Integer.parseInt(sc.nextLine());

                    System.out.print("Địa chỉ: ");
                    String address = sc.nextLine();

                    System.out.print("Điểm: ");
                    double point = Integer.parseInt(sc.nextLine());

                    System.out.print("Lớp: ");
                    String classroom = sc.nextLine();

                    Student newStudent = new Student(id, name, age, address, point, classroom);
                    studentService.addStudent(newStudent);
                    break;
                case 3:
                    System.out.print("Id của học sinh muốn cập nhật: ");
                    int idUpdate = Integer.parseInt(sc.nextLine());
                    studentService.showFindStudentById(idUpdate);

                    if (studentService.checkStudentById(idUpdate) > 0) {
                        System.out.print("Nhập điểm mới: ");
                        double pointUpdate = Integer.parseInt(sc.nextLine());
                        studentService.updatePoint(idUpdate, pointUpdate);
                    }

                    break;
                case 4:
                    System.out.print("Id của học sinh muốn xóa: ");
                    int idDelete = Integer.parseInt(sc.nextLine());
                    studentService.showFindStudentById(idDelete);
                    break;
                case 5:
                    System.out.print("Lớp muốn tìm: ");
                    String classroomFind = sc.nextLine();
                    studentService.findStudentByClassoom(classroomFind);
                    break;
                case 6:
                    studentService.sortStudentsByName();
                    break;
                case 7:
                    studentService.sortStudentsByAge();
                    break;
                case 8:
                    studentService.sortStudentsByPoint();
                    break;
                case 9:
                    isQuit = true;
                    break;
                default:{
                    System.out.println("Lựa chọn không hợp lệ");
                }
            }
        }
    }

    public void showMenu() {
        System.out.println("\n------------MENU------------");
        System.out.println(
                        "1. Xem danh sách học sinh\n" +
                        "2. Thêm học sinh mới\n" +
                        "3. Cập nhật điểm học sinh\n" +
                        "4. Xóa học sinh\n" +
                        "5. Xem danh sách học sinh theo lớp\n" +
                        "6. Sắp xếp theo tên\n" +
                        "7. Sắp xếp theo tuổi\n" +
                        "8. Sắp xếp theo điểm\n" +
                        "9. Thoát");
    }


}
