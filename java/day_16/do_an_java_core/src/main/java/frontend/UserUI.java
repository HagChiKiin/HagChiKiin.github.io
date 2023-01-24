package frontend;

import backend.controller.AdminController;
import backend.controller.StudentController;
import backend.controller.SubjectController;
import backend.controller.UserController;
import backend.database.AdminDB;
import backend.database.UserDB;
import backend.exception.NotFoundException;


import backend.model.Admin;
import backend.model.Student;
import backend.model.User;
import backend.regex.Regex;
import backend.request.*;

import java.util.ArrayList;
import java.util.Scanner;

public class UserUI {
    private final UserController userController = new UserController();
    StudentController studentController = new StudentController();
    AdminController adminController = new AdminController();
    User user = new User();
    StudentUI studentUI = new StudentUI();
    Regex regex = new Regex();

    // Method menu chính - menu 1
    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            // Xử lý lỗi có thể xảy ra khi ép kiểu ( Nhập sai định dạng cho phép )  - Numberformatexception
            try {
                System.out.println("Nhập lựa chọn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("CHỈ ĐƯỢC LỰA CHỌN 1 ĐẾN 5\n"); // Code xử lý ngoại lệ
                continue;
            }
            switch (option) {
                case 1: {
                    run1();

                    break;
                }
                case 2: {
                    register();
                    break;
                }
                case 3: {
                    forgotPassword();
                    break;
                }

                case 4: {
                    System.out.println("    Trường THPT Liên Hà - Hà Nội được đánh giá là một trong những trường có chất lượng đào tạo tốt tại Hà Nội. Với đội ngũ giáo viên nhà trường là những người có chuyên môn cao,\n" +
                            "giàu kinh nghiệm trong công tác giảng dạy. Đến năm 2016 trường có 23% giáo viên có trình độ thạc sĩ. Trong mỗi năm học, các thầy cô luôn thi đua viết ra những sáng kiến,\n" +
                            "kinh nghiệm của mình và từ những sáng kiến, kinh nghiệm đó đã có rất nhiều thầy cô đạt giáo viên giỏi cấp trường, cấp thành phố.\n" +
                            "\n" +
                            "   Trường THPT Liên Hà liên tục đạt được danh hiệu trường tiên tiến xuất sắc, được tặng nhiều giấy khen từ UBND thành phố Hà Nội, bằng khen của Thủ tướng chính phủ.\n" +
                            "Trường THPT Liên Hà cũng là trường đầu tiên đạt chuẩn quốc gia tại huyện Đông Anh. ");
                    break;
                }
                case 5: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("LỰA CHỌN KHÔNG HỢP LỆ");
                }
            }
        }
    }

    // In ra Menu 1
    public void showMenu() {
        System.out.println("\n☺☺☺☺☺☺☺CHÀO MỪNG ĐẾN VỚI TRANG QUẢN LÝ TUYỂN SINH CẤP 3 TRƯỜNG PTTH LIÊN HÀ☺☺☺☺☺☺☺");
        System.out.println("1 - Đăng nhập");
        System.out.println("2 - Đăng ký");
        System.out.println("3 - Quên mật khẩu");
        System.out.println("4 - Giới thiệu về trường THPT Liên Hà");
        System.out.println("5 - Thoát");
    }

    // Method đăng ký username, email, password mới
    public void register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập username mới : ");
        String newUserName = sc.nextLine();
        ArrayList<User> users1 = userController.findAll();
        ArrayList<Admin> admins = adminController.findAll();
        boolean isQuit = false;
        while (!isQuit) {
            System.out.print("Nhập email mới : ");
            String newEmail = sc.nextLine();
            boolean usermail = false;
            boolean adminmail = false;
            for (User b : users1) {
                // Kiểm tra trùng email trong file user json
                if (b.getEmail().equalsIgnoreCase(newEmail)) {
                    usermail = true;
                }
            }
            for (Admin a : admins
            ) { // Kiểm tra trùng email trong file admin json
                if (a.getEmail().equalsIgnoreCase(newEmail)) {
                    adminmail = true;
                }
            }
            if (usermail || adminmail) {
                System.out.println("EMAIL ĐÃ TỒN TẠI");
                System.out.println("----------------");
            } else {
                // Kiểm tra định dạng email
                if (regex.checkEmail(newEmail)) {
                    boolean isQuit1 = false;
                    while (!isQuit1) {
                        System.out.print("Nhập mật khẩu mới: ");
                        String newPassword = sc.nextLine();
                        // Kiểm tra điều kiện password >= 8 ký tự

                        if (newPassword.length() >= 8) {

                            CreateUser rq = new CreateUser(newUserName, newEmail, newPassword);
                            try {
                                User user1 = userController.register(rq);
                                System.out.println("ĐĂNG KÝ THÀNH CÔNG ☺");
                                System.out.printf("%-20s %-20s %-20s\n", "Username", "Email", "Password");
                                System.out.println(user1);
                            } catch (NotFoundException e) { // Xử lý ngoại lệ khi k tìm thấy user
                                {
                                    System.out.println(e.getMessage());
                                }
                            }
                            isQuit = true;
                            break;
                        } else {
                            System.out.println("MẬT KHẨU PHẢI CÓ TRÊN 8 KÝ TỰ");
                            System.out.println("-----------------------------");
                        }
                    }
                } else {
                    System.out.println("EMAIL KHÔNG HỢP LỆ");
                    System.out.println("------------------");
                }
            }
        }
    }

    // Method quên mật khẩu
    private void forgotPassword() {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> users = userController.findAll();
        ArrayList<Admin> admins = adminController.findAll();
        boolean isQuit = false;
        while (!isQuit) {
            System.out.print("Nhập email cần đổi mật khẩu : ");
            String email = sc.nextLine();
            boolean usermail = false;
            boolean adminmail = false;
            for (User b : users) {
                // Kiểm tra trùng email trong file user json
                if (b.getEmail().equalsIgnoreCase(email)) {
                    usermail = true;
                }
            }
            for (Admin a : admins
            ) { // Kiểm tra trùng email trong file admin json
                if (a.getEmail().equalsIgnoreCase(email)) {
                    adminmail = true;
                }
            }
            if (!usermail && !adminmail) {
                System.out.println("EMAIL KHÔNG TỒN TẠI");
                System.out.println("-------------------");
            } else if (usermail) {
                while (!isQuit) {
                    System.out.print("Nhập mật khẩu mới: ");
                    String newPassword = sc.nextLine();
                    if (newPassword.length() >= 8) {
                        ChangePassword rq = new ChangePassword(newPassword);
                        try {
                            User user3 = userController.forgotPassWord(email, rq);
                            System.out.println("ĐỔI MẬT KHẨU THÀNH CÔNG☻");
                            System.out.printf("%-20s %-20s %-20s\n", "Username", "Email", "Password");
                            System.out.println(user3);
                        } catch (NotFoundException e) {
                            {
                                System.out.println(e.getMessage());
                            }
                        }
                        isQuit = true;
                        break;
                    } else {
                        System.out.println("MẬT KHẨU PHẢI CÓ TRÊN 8 KÝ TỰ");
                        System.out.println("-----------------------------");
                    }
                }
            } else {
                while (!isQuit) {
                    System.out.print("Nhập mật khẩu mới: ");
                    String newPassword = sc.nextLine();
                    if (newPassword.length() >= 8) {
                        ChangePassword rq = new ChangePassword(newPassword);
                        try {
                            Admin admin = adminController.forgotPassWord(email, rq);
                            System.out.println("ĐỔI MẬT KHẨU THÀNH CÔNG☻");
                            System.out.printf("%-20s %-20s %-20s\n", "Username", "Email", "Password");
                            System.out.println(admin);
                        } catch (NotFoundException e) {
                            {
                                System.out.println(e.getMessage());
                            }
                        }
                        isQuit = true;
                        break;
                    } else {
                        System.out.println("MẬT KHẨU PHẢI CÓ TRÊN 8 KÝ TỰ");
                        System.out.println("------------------------------");
                    }
                }
            }
        }
    }

    // Method menu 2
    public void run1() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit1 = false;
        boolean isQuit2 = false;
        boolean check = false;
        boolean check1 = false;
        System.out.println("Nhập email: ");
        String email = sc.nextLine();
        System.out.println("Nhập password: ");
        String passWord = sc.nextLine();
        ArrayList<User> users = UserDB.users;
        ArrayList<Admin> admins = AdminDB.admins;
        for (User a : users) {
            // Sau khi đăng nhập thành công thì thực hiên tiếp các chức năng
            if (a.getEmail().equalsIgnoreCase(email) && a.getPassWord().equalsIgnoreCase((passWord))) {
                System.out.println("♥♥♥CHÚC MỪNG " + a.getUserName().toUpperCase() + " ĐÃ ĐĂNG NHẬP THÀNH CÔNG♥♥♥");
                check = true;
                while (!isQuit1) {
                    showMenu1();
                    try {
                        System.out.println("Nhập lựa chọn: ");
                        option = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("CHỈ ĐƯỢC LỰA CHỌN 1 ĐẾN 3\n");
                        continue;
                    }
                    switch (option) {
                        case 1: {
                            studentUI.run();
                            break;
                        }
                        case 2: {
                            boolean back1 = false;
                            while (!back1) {
                                System.out.println("Nhập email của bạn:");
                                String email1 = sc.nextLine();
                                if (email1.equalsIgnoreCase(a.getEmail())) {
                                    System.out.println("Nhập vào username mới của bạn");
                                    String newUsername = sc.nextLine();
                                    ArrayList<User> users1 = userController.findAll();
                                    ChangeUsername request = new ChangeUsername(newUsername);
                                    try {
                                        // changeUsername - method đổi tên username dựa trên email của tài khoản
                                        User user1 = userController.changeUsername(email1, request);
                                        System.out.println("Thay đổi thành công♥");
                                        System.out.println("THÔNG TIN USER SAU KHI THAY ĐỔI LÀ ");
                                        System.out.printf("%-20s %-20s %-20s\n", "Username", "Email", "Password");
                                        System.out.println(user1);
                                        // Xử lý ngoại lệ
                                    } catch (NotFoundException e) {
                                        {
                                            System.out.println(e.getMessage());
                                        }
                                    }
                                    break;
                                } else {
                                    System.out.println("Không phải email của bạn, vui lòng nhập lại email!");
                                    System.out.println("--------------------------------------------------");
                                }

                            }
                            break;
                        }
                        case 3: {
                            isQuit1 = true;
                            break;
                        }
                        default: {
                            System.out.println("LỰA CHỌN KHÔNG HỢP LỆ\n");
                        }
                    }
                }
            }

        }

        for (Admin b : admins) {
            if (b.getEmail().equalsIgnoreCase(email) && b.getPassWord().equalsIgnoreCase((passWord))) {
                System.out.println("♥♥♥CHÚC MỪNG " + b.getUserName().toUpperCase() + " ĐÃ ĐĂNG NHẬP THÀNH CÔNG♥♥♥");
                check1 = true;
                while (!isQuit2) {
                    showMenu2();
                    try {
                        System.out.println("Nhập lựa chọn: ");
                        option = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("CHỈ ĐƯỢC LỰA CHỌN 1 ĐẾN 10\n");
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
                            boolean idcheck = false;
                            while (!idcheck) {
                                try {
                                    System.out.print("Nhập id mới : ");
                                    int newId = Integer.parseInt(sc.nextLine());
                                    if (newId > 0) {
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
                                            System.out.println("-----------------------------");
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
                                                break;
                                            } catch (NotFoundException e) {
                                                {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("KHÔNG ĐƯỢC NHẬP ID LÀ SỐ ÂM");
                                        System.out.println("---------------------------");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN");
                                    System.out.println("--------------------------");
                                }
                            }
                            break;
                        }
                        case 3: {
                            boolean idcheck = false;
                            while (!idcheck) {
                                try {
                                    System.out.println("Nhập id cần xóa: ");
                                    int id = Integer.parseInt(sc.nextLine());
                                    if (id > 0) {
                                        try {
                                            studentController.deleteStudent(id);
                                            System.out.println("XÓA HỌC SINH THÀNH CÔNG☻");
                                            System.out.printf("%-5s %-25s %-15s %-8s %-20s\n",
                                                    "Id", "Fullname", "Birthday", "Gender", "Address");
                                            ArrayList<Student> students = studentController.findAll();
                                            students.forEach(System.out::println);
                                            break;
                                        } catch (NotFoundException e) {
                                            System.out.println(e.getMessage());
                                        }
                                    } else {
                                        System.out.println("KHÔNG ĐƯỢC NHẬP ID LÀ SỐ ÂM");
                                        System.out.println("---------------------------");
                                    }

                                } catch (NumberFormatException e) {
                                    System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN");
                                    System.out.println("--------------------------");
                                }
                            }
                            break;
                        }
                        case 4: {
                            boolean idcheck = false;
                            while (!idcheck) {
                                try {
                                    System.out.println("Nhập vào id học sinh cần chỉnh sửa thông tin");
                                    int id = Integer.parseInt(sc.nextLine());
                                    if (id > 0) {
                                        ArrayList<Student> students = studentController.findAll();
                                        boolean iCheck = false;
                                        for (Student s : students
                                        ) {
                                            if (s.getId() == id) {
                                                iCheck = true;
                                            }
                                        }
                                        if (!iCheck) {
                                            System.out.println("KHÔNG TÌM THẤY HỌC SINH CÓ ID " + id);
                                            System.out.println("---------------------------------");
                                        } else {
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
                                                break;
                                            } catch (NotFoundException e) {
                                                {
                                                    System.out.println(e.getMessage());
                                                }
                                            }
                                        }
                                    } else {
                                        System.out.println("KHÔNG ĐƯỢC NHẬP ID LÀ SỐ ÂM");
                                        System.out.println("---------------------------");
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN");
                                    System.out.println("--------------------------");
                                }
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
                            subjectController.showListStudentA4();
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
                            isQuit2 = true;
                            break;
                        }
                        default: {
                            System.out.println("LỰA CHỌN KHÔNG HỢP LỆ\n");
                        }
                    }
                }
            }

        }
        if (!check && !check1) {
            System.out.println("TÀI KHOẢN HOẶC MẬT KHẨU KHÔNG CHÍNH XÁC");
        }
    }

    // In ra menu chức năng của user admin
    public void showMenu2() {
        System.out.println("\n☺☺☺☺CHỌN CÁC CHỨC NĂNG CỦA ADMIN☺☺☺☺");
        System.out.println("1 - In ra thông tin các học sinh dự tuyển ");
        System.out.println("2 - Thêm thông tin học sinh dự tuyển ");
        System.out.println("3 - Xóa thông tin học sinh dự tuyển");
        System.out.println("4 - Sửa thông tin học sinh dự tuyển");
        System.out.println("5 - In ra danh sách học sinh đạt chỉ tiêu vào lớp A1");
        System.out.println("6 - In ra danh sách học sinh đạt chỉ tiêu vào lớp A2");
        System.out.println("7 - In ra danh sách học sinh đạt chỉ tiêu vào lớp A3");
        System.out.println("8 - In ra danh sách học sinh đạt chỉ tiêu vào lớp A4");
        System.out.println("9 - In ra danh sách học sinh không đạt chỉ tiêu dự tuyển");
        System.out.println("10 - Quay lại");
    }

    public void showMenu1() {
        System.out.println("\n☺☺☺☺CHỌN CÁC CHỨC NĂNG CỦA HỌC SINH☺☺☺☺");
        System.out.println("1 - Thông tin học sinh và điểm thi ");
        System.out.println("2 - Thay đổi username ");
        System.out.println("3 - Trở lại");
    }
}