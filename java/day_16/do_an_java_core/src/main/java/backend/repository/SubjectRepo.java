package backend.repository;

import backend.database.SubjectDB;
import backend.model.Subject;
import backend.utils.SubjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SubjectRepo {
    SubjectDB subjectDB = new SubjectDB();

    // In ra điểm thi các môn dựa trên id và name
    public ArrayList<Subject> pointLookUp(int id, String name) {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        ArrayList<Subject> rs = new ArrayList<>();
        boolean iXist = false;
        for (Subject s : subjects
        ) {
            if (s.getIdStudent() == id && s.getName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(s);
                iXist = true;
            }
        }
        if (!iXist) {
            System.out.println("Vui lòng kiểm tra lại");
        }
        return rs;
    }

    // Kiểm tra kết quả thi dựa trên id và name của học sinh
    public ArrayList<Subject> examResult(int id, String name) {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        List<Subject> subjects1 = subjects.stream().sorted((o1, o2) -> (int) (((o2.getMathPoint() + o2.getLiteraturePoint() + o2.getEnglishPoint() * 2) / 4) * 1000 -
                ((o1.getMathPoint() + o1.getLiteraturePoint() + o1.getEnglishPoint() * 2) / 4) * 1000)).collect(Collectors.toList());
        boolean iXist = false;
        for (int i = 0; i < subjects1.size(); i++) {
            if (subjects1.get(i).getIdStudent() == id && subjects1.get(i).getName().toLowerCase().contains(name.toLowerCase())){
                iXist = true;
                if (i < 4) {
                    System.out.println("CHÚC MỪNG BẠN "+name.toUpperCase()+" CÓ ID LÀ "+id+" ĐÃ ĐỦ CHỈ TIÊU VÀO LỚP A1☺");
                    System.out.println("-----------DANH SÁCH ĐIỂM THI CỦA CÁC HỌC SINH ĐỖ LỚP A1-----------");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjects1.subList(0,4).forEach(System.out::println);
                } else if (i < 8) {
                    System.out.println("CHÚC MỪNG BẠN "+name.toUpperCase()+" CÓ ID LÀ "+id+" ĐÃ ĐỦ CHỈ TIÊU VÀO LỚP A2☺");
                    System.out.println("-----------DANH SÁCH ĐIỂM THI CỦA CÁC HỌC SINH ĐỖ LỚP A2-----------");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjects1.subList(4,8).forEach(System.out::println);
                } else if (i < 12) {
                    System.out.println("CHÚC MỪNG BẠN "+name.toUpperCase()+" CÓ ID LÀ "+id+" ĐÃ ĐỦ CHỈ TIÊU VÀO LỚP A3☺");
                    System.out.println("-----------DANH SÁCH ĐIỂM THI CỦA CÁC HỌC SINH ĐỖ LỚP A3-----------");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjects1.subList(8,12).forEach(System.out::println);
                } else if (i < 16) {
                    System.out.println("CHÚC MỪNG BẠN "+name.toUpperCase()+" CÓ ID LÀ "+id+" ĐÃ ĐỦ CHỈ TIÊU VÀO LỚP A4☺");
                    System.out.println("-----------DANH SÁCH ĐIỂM THI CỦA CÁC HỌC SINH ĐỖ LỚP A4-----------");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjects1.subList(12,16).forEach(System.out::println);
                } else {
                    System.out.println("RẤT TIẾC BẠN "+name.toUpperCase()+" CÓ ID LÀ "+id+" CHƯA ĐỦ CHỈ TIÊU VÀO TRƯỜNG LIÊN HÀ☹");
                    System.out.println("-----------DANH SÁCH ĐIỂM THI CỦA CÁC HỌC SINH KHÔNG ĐỖ-----------");
                    System.out.printf("%-5s %-10s %-12s %-20s %-15s\n",
                            "Id", "Name", "Math point", "Literature point", "English point");
                    subjects1.subList(16,100).forEach(System.out::println);
                }
                break;
            }
        }
        if (!iXist) {
            System.out.println("KHÔNG CÓ HỌC SINH NÀO CÓ TÊN " + name.toUpperCase() + " VÀ CÓ ID LÀ " + id);
            System.out.println("--------------------------------------------------");
        }
        return subjects;
    }

    // In ra danh sách học sinh đủ tiêu chí vào lớp A1
    public void showListStudentA1() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        List<Subject> subjects1 = subjects.stream().sorted((o1, o2) -> (int) (((o2.getMathPoint() + o2.getLiteraturePoint() + o2.getEnglishPoint() * 2) / 4)*1000 -
                ((o1.getMathPoint() + o1.getLiteraturePoint() + o1.getEnglishPoint() * 2) / 4)*1000)).collect(Collectors.toList());
        subjects1.stream().limit(4).forEach(System.out::println);
    }

    // In ra danh sách học sinh đủ tiêu chí vào lớp A2
    public void showListStudentA2() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        List<Subject> subjects1 = subjects.stream().sorted((o1, o2) -> (int) (((o2.getMathPoint() + o2.getLiteraturePoint() + o2.getEnglishPoint() * 2) / 4)*1000 -
                ((o1.getMathPoint() + o1.getLiteraturePoint() + o1.getEnglishPoint() * 2) / 4)*1000)).collect(Collectors.toList());
        subjects1.stream().skip(4).limit(4).forEach(System.out::println);
    }

    // In ra danh sách học sinh đủ tiêu chí vào lớp A3
    public void showListStudentA3() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        List<Subject> subjects1 = subjects.stream().sorted((o1, o2) -> (int) (((o2.getMathPoint() + o2.getLiteraturePoint() + o2.getEnglishPoint() * 2) / 4)*1000 -
                ((o1.getMathPoint() + o1.getLiteraturePoint() + o1.getEnglishPoint() * 2) / 4)*1000)).collect(Collectors.toList());
        subjects1.stream().skip(8).limit(4).forEach(System.out::println);
    }

    // In ra danh sách học sinh đủ tiêu chí vào lớp A4
    public void showListStudentA4() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        List<Subject> subjects1 = subjects.stream().sorted((o1, o2) -> (int) (((o2.getMathPoint() + o2.getLiteraturePoint() + o2.getEnglishPoint() * 2) / 4)*1000 -
                ((o1.getMathPoint() + o1.getLiteraturePoint() + o1.getEnglishPoint() * 2) / 4)*1000)).collect(Collectors.toList());
        subjects1.stream().skip(12).limit(4).forEach(System.out::println);
    }

    // In ra danh sách trượt
    public void showListStudentFail() {
        ArrayList<Subject> subjects = SubjectDB.subjects;
        List<Subject> subjects1 = subjects.stream().sorted((o1, o2) -> (int) (((o2.getMathPoint() + o2.getLiteraturePoint() + o2.getEnglishPoint() * 2) / 4)*1000 -
                ((o1.getMathPoint() + o1.getLiteraturePoint() + o1.getEnglishPoint() * 2) / 4)*1000)).collect(Collectors.toList());
        subjects1.stream().skip(16).limit(20).forEach(System.out::println);
    }
}