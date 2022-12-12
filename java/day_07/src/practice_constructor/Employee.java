package practice_constructor;

public class Employee {
    public String name;
    public int age;
    public String address;
    public int totalHours;

    public int bonus;
    //public không có tham số
    public Employee(){}

    //constructor đầy đủ tham số
    public Employee(String name, int age, String address, int totalHours) {
        this.name = name;
        this.age = age;
        this.address = address;
        this.totalHours = totalHours;
    }
    public void printInfo(){
        System.out.println(name+" - "+age+" - "+address+" - "+totalHours*200000);
    }

    public int getSalary(){
        if(totalHours >= 200 ){
            bonus =  totalHours*200000*20/100;
        } else if (totalHours>=100 && totalHours<200) {
            bonus =  totalHours*200000*10/100;
        }
        else {
            bonus = 0;
        }
        return bonus;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                ", totalHours=" + totalHours +
                ", bonus=" + bonus +
                '}';
    }
}
