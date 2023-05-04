package demo_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main03 {
    public static void main(String[] args) {
        Student[] sinhvien = new Student[10];
        for (int i = 0; i < 10; i++) {
            sinhvien[i] = new Student(i,"Nguyễn Văn "+i,i);

        }
        System.out.println(Arrays.toString(sinhvien));

        List<Student> students = Arrays.asList(sinhvien);  // chuyển từ mảng thành list
        students.sort((o1, o2) -> (int) (o1.getGpa() - o2.getGpa()));

        students.sort(Comparator.comparing(Student::getGpa));

        for (int i = 0; i < sinhvien.length -1; i++) {
            for (int j=i+1; j < sinhvien.length ; j++) {
                if(sinhvien[i].getGpa() > sinhvien[j].getGpa()){
                    Student temp = sinhvien[i];
                    sinhvien[i] = sinhvien[j];
                    sinhvien[j]= temp;
                }
            }
        }
    }


}
