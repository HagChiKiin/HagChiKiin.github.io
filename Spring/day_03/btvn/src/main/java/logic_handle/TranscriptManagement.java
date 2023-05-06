package logic_handle;

import entity.Student;
import entity.Subject;
import entity.SubjectDetail;
import entity.Transcript;

import java.util.*;

public class TranscriptManagement {
    private List<Transcript> transcripts;
    private StudentManagement studentManagement;
    private SubjectManagement subjectManagement;

    public TranscriptManagement(StudentManagement studentManagement, SubjectManagement subjectManagement) {
        this.transcripts = new ArrayList<>();
        this.subjectManagement = subjectManagement;
        this.studentManagement = studentManagement;
    }

    public void enterTranscript() {
        if (studentManagement.isEmptyStudent() || subjectManagement.isEmptySubject()) {
            System.out.println("Cần nhập danh sách sinh vên và môn học trước khi thực hiện nhập điểm");
            return;
        }
        System.out.println("Muốn nhập điểm cho bao nhiêu sinh viên:");
        int studentNumber;
        do {
            try {
                studentNumber = new Scanner(System.in).nextInt();
                if (studentNumber > 0) {
                    break;
                }
                System.out.println("Số lượng sinh viên nhập vào phải lơn hơn 0, nhập lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số: ");
            }
        } while (true);

        for (int i = 1; i <= studentNumber; i++) {
            System.out.println("Nhập ID của sinh viên thứ " + i + " mà bạn muốn chấm công: ");
            int studentId;
            Student student;
            do {
                try {
                    studentId = new Scanner(System.in).nextInt();
                    student = studentManagement.findById(studentId);
                    if (student != null) {
                        break;
                    }
                    System.out.println("ID không tồn tại trong hệ thống, vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Vui lòng nhập số: ");
                }
            } while (true);

            System.out.println("Sinh viên có id " + i + " đã học bao nhiêu môn  ");
            int subjectNumber;
            do {
                try {
                    subjectNumber = new Scanner(System.in).nextInt();
                    if (subjectNumber > 0) {
                        break;
                    }
                    System.out.println("Số môn học nhập vào phải lơn hơn 0, vui lòng nhập lại: ");
                } catch (InputMismatchException ex) {
                    System.out.println("Vui lòng nhập số: ");
                }
            } while (true);

            List<SubjectDetail> subjectDetails = new ArrayList<>();
            for (int j = 1; j <= subjectNumber; j++) {
                System.out.println("Nhập mã id của môn học " + j + " mà sinh viên này đã học");
                int subjectId;
                Subject subject;
                do {
                    try {
                        subjectId = new Scanner(System.in).nextInt();
                        subject = subjectManagement.findById(subjectId);
                        if (subject != null) {
                            break;
                        }
                        System.out.println("ID không tồn tại trong hệ thống, vui lòng nhập lại: ");
                    } catch (InputMismatchException ex) {
                        System.out.println("Vui lòng nhập số: ");
                    }
                } while (true);

                System.out.println("Sinh viên này có số điểm môn vừa nhập là: ");
                float point;
                do {
                    try {
                        point = new Scanner(System.in).nextInt();
                        if (point >= 0 && point <= 10) {
                            break;
                        }
                        System.out.println("Số điểm phải từ khoảng 0 đến 10, vui lòng nhập lại: ");
                    } catch (InputMismatchException ex) {
                        System.out.println("Vui lòng nhập số: ");
                    }
                } while (true);

                SubjectDetail subjectDetail = new SubjectDetail(subject, point);
                subjectDetails.add(subjectDetail);
            }

            Transcript transcript = new Transcript(student, subjectDetails);
            transcripts.add(transcript);
        }
        showInfo();
    }

    public void showInfo() {
        transcripts.forEach(System.out::println);
    }

    public void sortMenu() {
        System.out.println("-------_SẮP XẾP DANH SÁCH BẢNG ĐIỂM--------");
        System.out.println("1. Sắp xếp theo họ tên sinh viên");
        System.out.println("2. Sắp xếp theo tên môn học");
        System.out.println("3. Quay lại menu chính");
        int choice;
        do {
            try {
                choice = new Scanner(System.in).nextInt();
                if (choice >= 1 && choice <= 3) {
                    break;
                }
                System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại: ");
            } catch (InputMismatchException ex) {
                System.out.println("Vui lòng nhập số từ 1 tới 3: ");
            }
        } while (true);
        switch (choice) {
            case 1:
                sortByStudentName();
                showInfo();
                break;
            case 2:
                sortBySubjectName();
                showInfo();
                break;
            case 3:
                return;
        }
    }

    private void sortByStudentName() {
        this.transcripts.sort((o1, o2) -> o1.getStudent().getName().compareToIgnoreCase(o2.getStudent().getName()));
    }

    private void sortBySubjectName() {
        this.transcripts.forEach(a -> a.getSubjectDetails().sort(((o1, o2)
                -> o1.getSubject().getName().compareToIgnoreCase(o2.getSubject().getName()))));
    }

    public void calculateTotalPoint() {
        if (this.transcripts.isEmpty()) {
            System.out.println("Cần thực hiện nhập điểm cho sinh viên trước khi tính điểm tổng kết");
            return;
        }
        transcripts.forEach(a-> {
            float totalPoint = 0;
            List<SubjectDetail> subjectDetails = a.getSubjectDetails();
            for (SubjectDetail subjectDetail : subjectDetails) {
                float tempTotalPoint = subjectDetail.getSubject().getCredit() * subjectDetail.getResult();
                totalPoint += tempTotalPoint;
            }
            System.out.println("Tổng điểm của sinh viên" + a.getStudent().getName() + " là: " + totalPoint);
        });
    }
}
