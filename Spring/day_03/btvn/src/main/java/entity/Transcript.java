package entity;

import java.util.List;

public class Transcript {
    private Student student;
    private List<SubjectDetail> subjectDetails;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<SubjectDetail> getSubjectDetails() {
        return subjectDetails;
    }

    public void setSubjectDetails(List<SubjectDetail> subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    @Override
    public String toString() {
        return "Transcript{" +
                "student=" + student +
                ", subjectDetails=" + subjectDetails +
                '}';
    }

    public Transcript(Student student, List<SubjectDetail> subjectDetails) {
        this.student = student;
        this.subjectDetails = subjectDetails;
    }
}
