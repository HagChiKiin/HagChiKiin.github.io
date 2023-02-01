package student_management.sevice;

import student_management.model.Student;

import java.util.Scanner;

public class StudentSevice {
    public Student createStudent() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập  tên: ");
        String name = sc.nextLine();
        System.out.println("Nhập điểm lý thuyết: ");
        double theoryPoint = Double.parseDouble(sc.nextLine());
        System.out.println("Nhập điểm thực hành: ");
        double practicePoint = Double.parseDouble(sc.nextLine());
        int id = (int) Math.floor(Math.random()*100);
        Student std = new Student(id,name,theoryPoint,practicePoint);
        return std;

    }
    public double calculateAvgPoint(double theoryPoint, double practicePoint) {
        double d = (theoryPoint + practicePoint)/2;
        return d ;

    }
    public void printInfo(Student s) { // truyền dữ liệu
        System.out.println("id: "+s.id);// biến tham chiếu là s
        System.out.println("name: "+s.name);
        System.out.println("theoryPoint: "+s.theoryPoint);
        System.out.println("practicePoint: "+s.practicePoint);
        System.out.println("avgPoint: " + calculateAvgPoint(s.theoryPoint, s.practicePoint));


    }

}

