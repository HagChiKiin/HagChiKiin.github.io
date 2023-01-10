package backend.repository;

import backend.database.SubjectDB;
import backend.model.Subject;

import java.util.ArrayList;

public class SubjectRepo {
    SubjectDB subjectDB = new SubjectDB();

    // In ra danh sách điểm thi dựa trên id
    public ArrayList<Subject> pointLookUp(int id) {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        ArrayList<Subject> rs = new ArrayList<>();
        boolean iXist = false;
        for (Subject s : subjects
        ) {
            if (s.getIdStudent() == id) {
                rs.add(s);
                iXist = true;
            }
        }
        if (!iXist) {
            System.out.println("Không có id: " + id + " vui lòng kiểm tra lại");
        }
        return rs;
    }

    public ArrayList<Subject> examResult(int id) {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        for (Subject s : subjects
        ) {
            if (s.getIdStudent() == id) {
                double a = (s.getMathPoint() + s.getLiteraturePoint() + s.getEnglishPoint() * 2) / 4;
                if(a >= 9){
                    System.out.println("Bạn đạt chỉ tiêu vào lớp A1");
                } else if (a >=8) {
                    System.out.println("Bạn đạt chỉ tiêu vào lớp A2");
                }else if (a >=7 ) {
                    System.out.println("Bạn đạt chỉ tiêu vào lớp A3 -> A5");
                }else if (a >=6) {
                    System.out.println("Bạn đạt chỉ tiêu vào lớp A6 -> A10");
                }else {
                    System.out.println("Bạn không đạt chỉ tiêu tuyển sinh");
                }
            }
        }
        return subjects;
    }
}