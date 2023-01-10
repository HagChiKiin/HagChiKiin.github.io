package frontend;

import backend.controller.SubjectController;
import backend.exception.NotFoundException;
import backend.model.Subject;

import java.util.ArrayList;
import java.util.Scanner;

public class SubjectUI {
    SubjectController subjectController = new SubjectController();

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean isQuit = false;
        while (!isQuit) {
            showMenu();
            try {
                System.out.println("Nhập lựa chọn: ");
                option = Integer.parseInt(sc.nextLine());
            } catch (NotFoundException e) {
                System.out.println("Chỉ được lựa chọn từ 1 đến 4\n");
                continue;
            }
            switch (option) {
                case 1: {
                    System.out.println("Nhập vào id của bạn: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập vào tên của bạn");
                    String name = sc.nextLine();
                    ArrayList<Subject> subjects = subjectController.pointLookUp(id, name);
                    if (subjects.isEmpty()) {
                        System.out.println("Không có học sinh nào có tên và id là: " + name + "-" + id);
                    } else {
                        System.out.println("Điểm của học sinh " + name + " có id: " + id + " như sau: ");
                        System.out.printf("%-5s %-10s %-12s %-12s %-12s\n",
                                "Id", "Name", "Math point", "Literature point", "English point");
                        for (Subject s : subjects
                        ) {
                            System.out.println(s);
                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhập vào id của bạn: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập vào tên của bạn");
                    String name = sc.nextLine();
                    ArrayList<Subject> subjects = subjectController.examResult(id, name);
                    if (subjects.isEmpty()) {
                        System.out.println("Không có học sinh nào có tên và id là: " + name + "-" + id);
                    }
                    break;
                }
                case 3: {
                    isQuit = true;
                    break;
                }
                default: {
                    System.out.println("Lựa chọn không hợp lệ");
                }
            }
        }
    }

    private void showMenu() {
        System.out.println("\n-----Vui lòng chọn các chức năng sau-----");
        System.out.println("1 - Tra cứu điểm thi ");
        System.out.println("2 - Kiểm tra kết quả phân lớp");
        System.out.println("3 - Quay lại");
    }
}

