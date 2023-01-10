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
                    ArrayList<Subject> subjects = subjectController.pointLookUp(id);
                    if (subjects.isEmpty()) {
                        System.out.println("Không có học sinh nào có id là: " + id);
                    } else {
                        System.out.println("Điểm của học sinh có id: " + id + " như sau: ");
                        System.out.printf("%-5s %-12s %-12s %-12s\n", "id", "MathPoint", "LiteraturePoint", "EnglishPoint");
                        for (Subject s: subjects
                             ) {
                            System.out.println(s);

                        }
                    }
                    break;
                }
                case 2: {
                    System.out.println("Nhập vào id của bạn: ");
                    int id = Integer.parseInt(sc.nextLine());
                    ArrayList<Subject> subjects = subjectController.examResult(id);

                    break;
                }
                case 3: {
                    break;
                }
                case 4: {
                    break;
                }
                case 5: {
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
        System.out.println("1 - Kiểm tra điểm thi ");
        System.out.println("2 - Kiểm tra kết quả phân lớp");
        System.out.println("3 - Quay lại");
    }
}

