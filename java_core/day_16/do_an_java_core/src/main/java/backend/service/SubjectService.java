package backend.service;

import backend.model.Subject;
import backend.repository.SubjectRepo;

import java.util.ArrayList;

public class SubjectService {
    SubjectRepo subjectRepo =new SubjectRepo();
    public ArrayList<Subject> pointLookUp(int id, String name) {
        return subjectRepo.pointLookUp(id, name);
    }

    public ArrayList<Subject> examResult(int id, String name) {
        return subjectRepo.examResult(id, name);
    }

    public void showListStudentA1() {
        subjectRepo.showListStudentA1();
    }

    public void showListStudentA2() {
        subjectRepo.showListStudentA2();
    }

    public void showListStudentA3() {
        subjectRepo.showListStudentA3();
    }

    public void showListStudentA4() {
        subjectRepo.showListStudentA4();
    }

    public void showListStudentFail() {
        subjectRepo.showListStudentFail();
    }
}
