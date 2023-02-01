package Encapsulation_Practice;

public class Student {
    private String id;
    private double avgPoint;
    private int age;
    private String classroom;

    public Student() {
    }

//    public Student(String id, double avgPoint, int age, String classroom) {
//        this.id = id;
//        this.avgPoint = avgPoint;
//        this.age = age;
//        this.classroom = classroom;
//    }
    public Student(String id, double avgPoint, int age, String classroom) {
        setId(id);
        setAvgPoint(avgPoint);
        setAge(age);
        setClassroom(classroom);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if(id.length()!= 8){
            System.out.println("Mã sinh viên phải chứ 8 ký tự");
            return;
        }
        this.id = id;
    }

    public double getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(double avgPoint) {
        if(avgPoint<0 && avgPoint>10){
            System.out.println("Điểm trung bình không hợp lệ");
            return;
        }
        this.avgPoint = avgPoint;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if(age<18){
            System.out.println("Tuổi phải lớn hơn 17");
            return;
        }
        this.age = age;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        if(classroom.charAt(0) == 'A' || classroom.charAt(0)== 'C'){
            System.out.println("Nhập đúng lớp");
        }else {
            System.out.println("Lớp phải bắt đầu bằng ký tự \"A\" hoặc \"C\" ");
            return;
        }
        this.classroom = classroom;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", avgPoint=" + avgPoint +
                ", age=" + age +
                ", classroom='" + classroom + '\'' +
                '}';
    }
    public  void showInfo(){
        System.out.println(this);

    }
    public void calculateScholarship(){
        if (avgPoint >=8){
            System.out.println("Nhận được học bổng");
        }else {
            System.out.println("Không nhận được gì");
        }
    }
}
