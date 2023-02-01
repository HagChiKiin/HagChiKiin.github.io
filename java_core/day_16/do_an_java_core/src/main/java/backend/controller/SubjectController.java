package backend.controller;

import backend.model.Subject;
import backend.service.SubjectService;

import java.util.ArrayList;

public class SubjectController {
    SubjectService subjectService = new SubjectService();
    // UI thao tác đến controller
    public ArrayList<Subject> pointLookUp(int id,String name) {
        return subjectService.pointLookUp(id,name);
    }

    public ArrayList<Subject> examResult(int id, String name) {
        return subjectService.examResult(id, name);
    }

    public void showListStudentA1() {
        subjectService.showListStudentA1();
    }

    public void showListStudentA2() {
        subjectService.showListStudentA2();
    }

    public void showListStudentA3() {
        subjectService.showListStudentA3();
    }

    public void showListStudentA4() {
        subjectService.showListStudentA4();
    }

    public void showListStudentFail() {
        subjectService.showListStudentFail();
    }
}
