package backend.repository;

import backend.database.SubjectDB;
import backend.model.Subject;

import java.util.ArrayList;

public class SubjectRepo {
    SubjectDB subjectDB = new SubjectDB();

    // In ra điểm thi các môn dựa trên id và name
    public ArrayList<Subject> pointLookUp(int id, String name) {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        ArrayList<Subject> rs = new ArrayList<>();
        boolean iXist = false;
        for (Subject s : subjects
        ) {
            if (s.getIdStudent() == id && s.getName().equalsIgnoreCase(name)) {
                rs.add(s);
                iXist = true;
            }
        }
        if (!iXist) {
            System.out.println("Không có học sinh " + name + " có id là " + id + " ,vui lòng kiểm tra lại");
        }
        return rs;
    }

    // Kiểm tra kết quả thi dựa trên id và name
    public ArrayList<Subject> examResult(int id, String name) {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        boolean iXist = false;
        for (Subject s : subjects
        ) {
            if (s.getIdStudent() == id && s.getName().equalsIgnoreCase(name)) {
                iXist = true;
                double a = (s.getMathPoint() + s.getLiteraturePoint() + s.getEnglishPoint() * 2) / 4;
                if (a >= 9) {
                    System.out.println("Bạn đạt chỉ tiêu vào lớp A1");
                } else if (a >= 8) {
                    System.out.println("Bạn đạt chỉ tiêu vào lớp A2");
                } else if (a >= 7) {
                    System.out.println("Bạn đạt chỉ tiêu vào lớp A3 -> A5");
                } else if (a >= 6) {
                    System.out.println("Bạn đạt chỉ tiêu vào lớp A6 -> A10");
                } else {
                    System.out.println("Bạn không đạt chỉ tiêu tuyển sinh");
                }
            }
            if (!iXist) {
                System.out.println("Không có học sinh " + name + " có id là " + id + " ,vui lòng kiểm tra lại");
            }
        }
        return subjects;
    }

    public void showListStudentA1() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        for (Subject s : subjects
        ) {
            double a = (s.getMathPoint() + s.getLiteraturePoint() + s.getEnglishPoint() * 2) / 4;
            if (a >= 9) {
                System.out.println(s);
            }
        }
    }

    public void showListStudentA2() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        for (Subject s : subjects
        ) {
            double a = (s.getMathPoint() + s.getLiteraturePoint() + s.getEnglishPoint() * 2) / 4;
            if (a >= 8 && a < 9) {
                System.out.println(s);
            }
        }
    }
    public void showListStudentA3() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        for (Subject s : subjects
        ) {
            double a = (s.getMathPoint() + s.getLiteraturePoint() + s.getEnglishPoint() * 2) / 4;
            if (a >= 7 && a < 8) {
                System.out.println(s);
            }
        }
    }
    public void showListStudentA6() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        for (Subject s : subjects
        ) {
            double a = (s.getMathPoint() + s.getLiteraturePoint() + s.getEnglishPoint() * 2) / 4;
            if (a >= 6 && a < 7) {
                System.out.println(s);
            }
        }
    }
    public void showListStudentFail() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        for (Subject s : subjects
        ) {
            double a = (s.getMathPoint() + s.getLiteraturePoint() + s.getEnglishPoint() * 2) / 4;
            if (a < 6) {
                System.out.println(s);
            }
        }
    }
}