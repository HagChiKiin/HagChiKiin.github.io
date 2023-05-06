package entity;

public class SubjectDetail {
    private Subject subject;
    private float result;

    @Override
    public String toString() {
        return "SubjectDetail{" +
                "subject=" + subject +
                ", result=" + result +
                '}';
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public float getResult() {
        return result;
    }

    public void setResult(float result) {
        this.result = result;
    }

    public SubjectDetail(Subject subject, float result) {
        this.subject = subject;
        this.result = result;
    }
}
