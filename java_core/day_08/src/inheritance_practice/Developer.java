package inheritance_practice;

public class Developer extends Employee {
    private int overtimeHours;

    public Developer() {
    }

    public Developer(int id, String name, int age, String phone, String email, int salaryBasic, int overtimeHours) {
        super(id, name, age, phone, email, salaryBasic);
        this.overtimeHours = overtimeHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }
    //tính lương
    public int calculateSalary(){
        return getSalaryBasic()+overtimeHours*200000;
    }
}
