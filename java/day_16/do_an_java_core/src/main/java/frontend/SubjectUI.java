package frontend;

import backend.controller.SubjectController;
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
            } catch (NumberFormatException e) {
                System.out.println("CHỈ ĐƯỢC LỰA CHỌN 1 ĐẾN 3\n");
                continue;
            }
            switch (option) {
                case 1: {
                    try {
                        System.out.println("Nhập vào id của bạn: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println("Nhập vào tên của bạn");
                        String name = sc.nextLine();
                        ArrayList<Subject> subjects = subjectController.pointLookUp(id, name);
                        if (subjects.isEmpty()) {
                            System.out.println("KHÔNG CÓ HỌC SINH NÀO CÓ TÊN LÀ: " + name.toUpperCase() + " VÀ CÓ ID LÀ: " + id);
                        } else {
                            System.out.println("ĐIỂM CỦA HỌC SINH CÓ NAME " + name.toUpperCase() + " VÀ CÓ ID: " + id + " NHƯ SAU: ");
                            System.out.printf("%-5s %-10s %-12s %-12s %-12s\n",
                                    "Id", "Name", "Math point", "Literature point", "English point");
                            for (Subject s : subjects
                            ) {
                                System.out.println(s);
                            }
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN\n");
                    }
                    break;
                }
                case 2: {
                    try {
                        System.out.println("Nhập vào id của bạn: ");
                        int id = Integer.parseInt(sc.nextLine());
                        System.out.println("Nhập vào tên của bạn");
                        String name = sc.nextLine();
                        ArrayList<Subject> subjects = subjectController.examResult(id, name);
                        if (subjects.isEmpty()) {
                            System.out.println("KHÔNG CÓ HỌC SINH NÀO CÓ TÊN LÀ: " + name.toUpperCase() + " VÀ CÓ ID LÀ: " + id);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("ID CHỈ ĐƯỢC NHẬP SỐ NGUYÊN\n");
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

    // Menu 3
    private void showMenu() {
        System.out.println("\n☺☺☺☺CHỌN CÁC CHỨC NĂNG DƯỚI ĐÂY☺☺☺☺");
        System.out.println("1 - Tra cứu điểm thi ");
        System.out.println("2 - Kết quả phân lớp");
        System.out.println("3 - Quay lại");
    }
}

