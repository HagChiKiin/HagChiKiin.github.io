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
                    System.out.println("Nhập vào tên của bạn:");
                    String name = sc.nextLine();
                    boolean idcheck = false;
                    while (!idcheck) {
                        try {
                            System.out.println("Nhập vào id của bạn");
                            int id = Integer.parseInt(sc.nextLine());
                            if (id >= 0) {
                                ArrayList<Student> students = studentController.getStudentById(name, id);
                                if (students.isEmpty()) {
                                    System.out.println("KHÔNG CÓ HỌC SINH NÀO TÊN LÀ: " + name.toUpperCase() + " ,MÀ CÓ ID LÀ : " + id);
                                    System.out.println("--------------------------------------------------");
                                } else {
                                    System.out.println("Thông tin học sinh có id " + id + " là :");
                                    System.out.printf("%-5s %-25s %-15s %-8s %-20s \n", "Id", "Fullname", "Birthday", "Gender", "Address");
                                    for (Student b : students
                                    ) {
                                        System.out.println(b);
                                    }
                                    System.out.println("---------------------------------------------");
                                }
                                break;
                            }else {
                                System.out.println("KHÔNG ĐƯỢC NHẬP ID LÀ SỐ ÂM");
                                System.out.println("---------------------------");
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN DƯƠNG");
                            System.out.println("--------------------------------");
                        }
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
        System.out.println("☺☺☺☺KIỂM TRA CÁC HẠNG MỤC DƯỚI ĐÂY☺☺☺☺");
        System.out.println("1 - Kiểm tra thông tin cá nhân ");
        System.out.println("2 - Kiểm tra kết quả thi ");
        System.out.println("3 - Quay lại");
    }


}