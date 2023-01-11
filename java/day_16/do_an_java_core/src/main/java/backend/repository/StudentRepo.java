package backend.repository;

import backend.database.StudentDB;
import backend.exception.NotFoundException;
import backend.model.Student;
import backend.model.User;
import backend.request.UpdateStudent;
import backend.utils.StudentUtils;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentRepo {
    ArrayList<Student> students = StudentDB.students;
    User user = new User();
    Scanner sc = new Scanner(System.in);
// In ra danh sách học sinh
    public ArrayList<Student> findAll() {
        return StudentDB.students;
    }
// In ra học sinh theo id và name
    public ArrayList<Student> getStudentById(String name, int id) {
        ArrayList<Student> students1 = StudentDB.students;
        ArrayList<Student> rs = new ArrayList<>();
        boolean ixist = false;
        for (Student s : students1
        ) {
            if (s.getId() == id && s.getFullName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(s);
                ixist = true;
            }
        }
        if (!ixist) {
            System.out.println("Nhập chưa đúng id và name, vui lòng kiểm tra lại");
        }
        return rs;
    }
// Thêm học sinh
    public void add(Student student) {
        StudentDB.students.add(student);
        StudentUtils.setDataToFile("student.json",StudentDB.students);
    }
// Tìm học sinh theo id
    public Student findById(int id) {
        for (Student b :StudentDB.students
        ) {
            if(b.getId()==id){
                return b;
            }
        }
        throw new NotFoundException("Không tìm thấy học sinh có id = "+id); // Sử dụng exception tự định nghĩa
    }
// Xóa trong biến và lưu lại trên file json
    public void delete(Student id) {
        StudentDB.students.remove(id);
        StudentUtils.setDataToFile("student.json",StudentDB.students);
    }
// Cạp nhật thông tin dựa theo id của học sinh
    public Student update(int id, UpdateStudent request) {
        Student student = findById(id);
        student.setFullName(request.getFullName());
        student.setBirthday(request.getBirthday());
        student.setGender(request.getGender());
        student.setAddress(request.getAddress());
        StudentUtils.setDataToFile("student.json",StudentDB.students);
        return student;
    }
}

