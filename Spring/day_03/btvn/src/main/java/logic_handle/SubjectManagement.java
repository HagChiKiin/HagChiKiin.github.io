package logic_handle;

import entity.Student;
import entity.Subject;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class SubjectManagement {
    private List<Subject> subjects;
    public SubjectManagement(){
        this.subjects = new ArrayList<>();
    }
    public void inputInfo() {
        System.out.println("Bạn muốn nhập cho bao nhiêu môn học: ");
        int subjectNumber;
        do {
            try {
                subjectNumber = new Scanner(System.in).nextInt();
                if (subjectNumber > 0) {
                    break;
                }
                System.out.println("Số lượng môn học nhập vào phải lơn hơn 0, vui lòng nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số: ");
            }
        } while (true);

        for (int i = 0; i < subjectNumber; i++) {
            Subject subject = new Subject();
            subject.inputInfo();
            subjects.add(subject);
        }
        showSubject();
    }

    public void showSubject() {
        subjects.forEach(System.out::println);
    }

    public Subject findById(int id) {
        for (int i = 0; i < subjects.size(); i++) {
            if (subjects.get(i).getId() == id) {
                return subjects.get(i);
            }
        }
        return null;
    }

    public boolean isEmptySubject() {
        return this.subjects.isEmpty();
    }

}
