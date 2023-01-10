package backend.controller;

import backend.model.Subject;
import backend.service.SubjectService;

import java.util.ArrayList;

public class SubjectController {
    SubjectService subjectService = new SubjectService();
    // UI thao tác đến controller
    public ArrayList<Subject> pointLookUp(int id) {
        return subjectService.pointLookUp(id);
    }

    public ArrayList<Subject> examResult(int id) {
        return subjectService.examResult(id);
    }
}
