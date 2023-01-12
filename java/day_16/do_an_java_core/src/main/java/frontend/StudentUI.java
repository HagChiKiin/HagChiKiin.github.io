package frontend;

import backend.controller.StudentController;
import backend.controller.SubjectController;
import backend.controller.UserController;
import backend.exception.NotFoundException;
import backend.model.Student;
import backend.model.Subject;
import backend.model.User;
import backend.repository.SubjectRepo;
import backend.request.CreateStudent;
import backend.request.UpdateStudent;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentUI {
    StudentController studentController = new StudentController();
    UserController userController = new UserController();
    Subject subject = new Subject();
    SubjectUI subjectUI = new SubjectUI();

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            try {
                System.out.println("Nhập lựa chọn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("CHỈ ĐƯỢC LỰA CHỌN 1 ĐẾN 3\n");
                continue;
            }
            switch (option) {
                case 1: {
                    System.out.println("Nhập vào name của bạn");
                    String name = sc.nextLine();
                    try {
                        System.out.println("Nhập vào id của bạn");
                        int id = Integer.parseInt(sc.nextLine());
                        ArrayList<Student> students = studentController.getStudentById(name, id);
                        if (students.isEmpty()) {
                            System.out.println("KHÔNG CÓ HỌC SINH NÀO TÊN LÀ: " + name.toUpperCase() +
                                    " ,MÀ CÓ ID LÀ : " + id);
                        } else {
                            System.out.println("Thông tin học sinh có id " + id + " là :");
                            System.out.printf("%-5s %-25s %-15s %-8s %-20s \n", "Id", "Fullname", "Birthday", "Gender", "Address");
                            for (Student b : students
                            ) {
                                System.out.println(b);
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN \n");
                    }
                    break;
                }
                case 2: {
                    subjectUI.run();
                    break;
                }
                case 3: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("LỰA CHỌN KHÔNG HỢP LỆ");
                }
            }
        }
    }

    // Menu 2 khi gọi chức năng học sinh
    public void showMenu() {
        System.out.println("☺☺☺☺CHỌN CHỨC NĂNG DƯỚI ĐÂY☺☺☺☺");
        System.out.println("1 - Kiểm tra thông tin cá nhân ");
        System.out.println("2 - Kiểm tra kết quả thi ");
        System.out.println("3 - Quay lại");
    }

    // Menu 2 khi gọi chức năng admin
    public void run1() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu1();
            try {
                System.out.println("Nhập lựa chọn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("CHỈ ĐƯỢC LỰA CHỌN TỪ 1 ĐẾN 10\n");
                continue;
            }
            switch (option) {
                case 1: {
                    ArrayList<Student> students = studentController.findAll();
                    System.out.printf("%-5s %-25s %-15s %-8s %-20s\n",
                            "Id", "Fullname", "Birthday", "Gender", "Address");
                    students.forEach(System.out::println);
                    break;
                }
                case 2: {
                    try {
                        System.out.print("Nhập id mới : ");
                        int newId = Integer.parseInt(sc.nextLine());
                        ArrayList<Student> students = studentController.findAll();
                        boolean iCheck = false;
                        for (Student s : students
                        ) {
                            if (s.getId() == newId) {
                                iCheck = true;
                            }
                        }
                        if (iCheck) {
                            System.out.println("KHÔNG ĐƯỢC TRÙNG VỚI ID ĐÃ CÓ");
                        } else {
                            System.out.print("Nhập họ và tên học sinh: ");
                            String newFullName = sc.nextLine();
                            System.out.print("Nhập ngày sinh: ");
                            String newBirthday = sc.nextLine();
                            System.out.print("Nhập giới tính: ");
                            String newGender = sc.nextLine();
                            System.out.print("Nhập địa chỉ: ");
                            String newAddress = sc.nextLine();
                            CreateStudent request = new CreateStudent(newId, newFullName, newBirthday, newGender, newAddress);
                            try {
                                Student student = studentController.addStudent(request);
                                System.out.println("THÊM HỌC SINH THÀNH CÔNG☻");
                                System.out.printf("%-5s %-25s %-15s %-8s %-20s\n",
                                        "Id", "Fullname", "Birthday", "Gender", "Address");
                                System.out.println(student);
                            } catch (NotFoundException e) {
                                {
                                    System.out.println(e.getMessage());
                                }
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN\n");
                        continue;
                    }
                    break;
                }
                case 3: {
                    try {
                        System.out.println("Nhập id cần xóa: ");
                        int id = Integer.parseInt(sc.nextLine());
                        try {
                            studentController.deleteStudent(id);
                            System.out.println("XÓA HỌC SINH THÀNH CÔNG☻");
                            System.out.printf("%-5s %-25s %-15s %-8s %-20s\n",
                                    "Id", "Fullname", "Birthday", "Gender", "Address");
                            ArrayList<Student> students = studentController.findAll();
                            students.forEach(System.out::println);
                        } catch (NotFoundException e) {
                            System.out.println(e.getMessage());
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN\n");
                    }
                    break;
                }
                case 4: {
                    try {
                        System.out.println("Nhập vào id học sinh cần chỉnh sửa thông tin");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println("Nhập vào họ và tên:  ");
                        String fullName = sc.nextLine();
                        System.out.println("Nhập vào ngày sinh: ");
                        String birthday = sc.nextLine();
                        System.out.println("Nhập vào giới tính: ");
                        String gender = sc.nextLine();
                        System.out.println("Nhập vào địa chỉ: ");
                        String address = sc.nextLine();
                        UpdateStudent request = new UpdateStudent(fullName, birthday, gender, address);
                        try {
                            Student student = studentController.update(id, request);
                            System.out.println("Thông tin học sinh sau khi cập nhật là: ");
                            System.out.printf("%-5s %-25s %-15s %-8s %-20s\n",
                                    "Id", "Fullname", "Birthday", "Gender", "Address");
                            System.out.println(student);
                        } catch (NotFoundException e) {
                            {
                                System.out.println(e.getMessage());
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN\n");
                    }
                    break;
                }
                case 5: {
                    SubjectController subjectController = new SubjectController();
                    System.out.println("DANH SÁCH HỌC SINH ĐỦ CHỈ TIÊU VÀO LỚP A1: ");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjectController.showListStudentA1();
                    break;
                }
                case 6: {
                    SubjectController subjectController = new SubjectController();
                    System.out.println("DANH SÁCH HỌC SINH ĐỦ CHỈ TIÊU VÀO LỚP A2: ");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjectController.showListStudentA2();
                    break;
                }
                case 7: {
                    SubjectController subjectController = new SubjectController();
                    System.out.println("DANH SÁCH HỌC SINH ĐỦ CHỈ TIÊU VÀO LỚP A3->A5: ");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjectController.showListStudentA3();
                    break;
                }
                case 8: {
                    SubjectController subjectController = new SubjectController();
                    System.out.println("DANH SÁCH HỌC SINH ĐỦ CHỈ TIÊU VÀO LỚP A6->A10: ");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjectController.showListStudentA6();
                    break;

                }
                case 9: {
                    SubjectController subjectController = new SubjectController();
                    System.out.println("DANH SÁCH HỌC SINH KHÔNG ĐỖ: ");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjectController.showListStudentFail();
                    break;
                }
                case 10: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("LỰA CHỌN KHÔNG HỢP LỆ");
                }
            }
        }
    }

    // In ra menu chức năng của user admin
    private void showMenu1() {
        System.out.println("\n☺☺☺☺CHỌN CÁC CHỨC NĂNG DƯỚI ĐÂY☺☺☺☺");
        System.out.println("1 - In ra thông tin các học sinh dự tuyển ");
        System.out.println("2 - Thêm thông tin học sinh dự tuyển ");
        System.out.println("3 - Xóa thông tin học sinh dự tuyển");
        System.out.println("4 - Sửa thông tin học sinh dự tuyển");
        System.out.println("5 - In ra danh sách học sinh đạt chỉ tiêu vào lớp A1");
        System.out.println("6 - In ra danh sách học sinh đạt chỉ tiêu vào lớp A2");
        System.out.println("7 - In ra danh sách học sinh đạt chỉ tiêu vào lớp A3-A5");
        System.out.println("8 - In ra danh sách học sinh đạt chỉ tiêu vào lớp A6-A10");
        System.out.println("9 - In ra danh sách học sinh không đạt chỉ tiêu dự tuyển");
        System.out.println("10 - Quay lại");
    }

}