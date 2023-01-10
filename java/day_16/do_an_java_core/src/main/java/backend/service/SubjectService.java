package backend.service;

import backend.model.Subject;
import backend.repository.SubjectRepo;

import java.util.ArrayList;

public class SubjectService {
    SubjectRepo subjectRepo =new SubjectRepo();
    public ArrayList<Subject> pointLookUp(int id) {
        return subjectRepo.pointLookUp(id);
    }

    public ArrayList<Subject> examResult(int id) {
        return subjectRepo.examResult(id);
    }
}
