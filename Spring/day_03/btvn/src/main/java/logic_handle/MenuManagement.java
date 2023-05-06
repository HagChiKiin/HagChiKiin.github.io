package logic_handle;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuManagement {
    private StudentManagement studentManagement;
    private SubjectManagement subjectManagement;
    private TranscriptManagement transcriptManagement;

    public MenuManagement() {
        this.studentManagement =new StudentManagement();
        this.subjectManagement = new SubjectManagement();
        this.transcriptManagement = new TranscriptManagement(studentManagement, subjectManagement);
    }

    public void menu(){
        while (true) {
            printMenu();
            int functionChoice = functionChoice();
            switch (functionChoice) {
                case 1:
                    studentManagement.inputInfo();
                    break;
                case 2:
                    subjectManagement.inputInfo();
                    break;
                case 3:
                    transcriptManagement.enterTranscript();
                    break;
                case 4:
                    transcriptManagement.sortMenu();
                    break;
                case 5:
                    transcriptManagement.calculateTotalPoint();
                    break;
                case 6:
                    return;
            }
        }
    }

    private void printMenu() {
        System.out.println("------------PHẦN MỀM QUẢN LÝ SINH VIÊN--------------");
        System.out.println("1. Nhập danh sách sinh viên mới và in ra màn hình");
        System.out.println("2. Nhập danh sách môn học mới và in ra màn hình");
        System.out.println("3. Nhập điểm cho mỗi sinh viên đã có và in ra màn hình");
        System.out.println("4. Sắp xếp danh sách bảng điểm");
        System.out.println("5. Điểm tổng kết theo môn học và đơn vị học trình");
        System.out.println("6. Thoát");
        System.out.println("Xin mời chọn chức năng: ");
    }

    private int functionChoice() {
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 6) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số từ 1 tới 6: ");
            }
        } while (true);
        return choice;
    }

}
