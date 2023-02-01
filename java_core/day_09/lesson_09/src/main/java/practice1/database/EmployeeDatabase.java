package practice1.database;

import practice1.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDatabase {
    public static ArrayList<Employee> employee = new ArrayList<>(List.of(
            new Employee(1,"Nguyễn Kiên","a@gmail.com",7_000_000),
            new Employee(2,"Nguyễn Ka","b@gmail.com",8_000_000),
            new Employee(3,"Nguyễn Ku","c@gmail.com",9_000_000),
            new Employee(4,"Nguyễn Ke","d@gmail.com",10_000_000),
            new Employee(5,"Nguyễn Ki","e@gmail.com",11_000_000),
            new Employee(6,"Nguyễn Kê","f@gmail.com",12_000_000)
    ));



}
