public class Student implements Comparable {
    public String fullName;
    public int age;
    public int GPA;

    public Student(String fullName, int age, int GPA) {
        this.fullName = fullName;
        this.age = age;
        this.GPA = GPA;
    }

    @Override
    public String toString() {
        return "student{" +
                "fullName='" + fullName + '\'' +
                ", age=" + age +
                ", GPA=" + GPA +
                '}';
    }

    @Override
    public int compareTo(Object other) {
        Student otherStudent = (Student) other;
        // 0 nếu this = other
        // 1 nếu this > other
        // -1 nếu this < other
        if (this.age == otherStudent.age) {
            return 0;
        } else if (this.age > otherStudent.age) {
            return 1;
        }
        return 1;
    }
}

