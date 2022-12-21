package service;

import model.Student;
import repository.StudentRepository;

import java.util.ArrayList;
import java.util.Comparator;

public class StudentService {
    StudentRepository studentRepository = new StudentRepository();
    ArrayList<Student> students = studentRepository.allStudent();

    public void showAllStudent() {
        for (Student student : students) {
            System.out.println(student);
        }
    }

    public void addStudent(Student std) {
        students.add(std);
        System.out.println("Thêm học sinh mới thành công! ");
    }

    public void updatePoint(int id, double point) {

        for (Student student : students) {
            if (student.getId() == id) {
                student.setPoint(point);
            }
        }
        System.out.println("Cập nhật điểm thành công!");
    }

    public void deleteStudent(int id) {
        ArrayList<Student> ToRemove = new ArrayList<>();
        for (Student student : students) {
            if (student.getId() == id) {
                ToRemove.add(student);
            }
        }
        students.removeAll(ToRemove);
        System.out.println("Xóa học sinh thành công!");
    }

    public void findStudentByClassoom(String classroom) {
        ArrayList<Student> studentByClassoom = new ArrayList<>();
        for (Student student : students) {
            if (student.getClassroom().toLowerCase().contains(classroom.toLowerCase())) {
                studentByClassoom.add(student);
            }
        }

        if (studentByClassoom.size() > 0) {
            for (Student student : studentByClassoom) {
                System.out.println(student);
            }
        } else {
            System.out.println("Không có học sinh nào lớp: " + classroom);
        }
    }


    public void sortStudentsByName() {
        ArrayList<Student> studentsClone = (ArrayList<Student>) students.clone();

        int STUDENT_CLONE_LENTH = studentsClone.size();

        studentsClone.sort((o1, o2) -> o2.getName().compareTo(o1.getName()));

        for (Student student : studentsClone) {
            System.out.println(student);
        }
    }


    public void sortStudentsByAge() {
        ArrayList<Student> studentsClone = (ArrayList<Student>) students.clone();
        studentsClone.sort(new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getAge() - o2.getAge();
            }
        });

        for (Student e : studentsClone) {
            System.out.println(e);
        }
    }

    public void sortStudentsByPoint() {
        ArrayList<Student> studentsClone = (ArrayList<Student>) students.clone();
        studentsClone.sort(new Comparator<>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getPoint() - o2.getPoint());
            }
        });

        for (Student e : studentsClone) {
            System.out.println(e);
        }


    }


    public int checkStudentById(int id) {
        ArrayList<Student> findStudentList = new ArrayList<>();
        int count = 0;

        for (Student student : students) {
            if (student.getId() == id) {
                findStudentList.add(student);
                count++;
            }
        }
        return count;
    }

    public void showFindStudentById(int id) {
        ArrayList<Student> findStudentList = new ArrayList<>();
        for (Student student : students) {
            if (student.getId() == id) {
                findStudentList.add(student);

            }
        }

    }

}

