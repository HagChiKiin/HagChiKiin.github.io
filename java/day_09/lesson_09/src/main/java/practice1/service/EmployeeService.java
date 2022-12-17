package practice1.service;

import practice1.model.Employee;
import practice1.repository.EmployeeRepository;

import java.util.ArrayList;

public class EmployeeService {
    EmployeeRepository employeeRepository = new EmployeeRepository();
    Employee employee = new Employee();
    public void printEmployee(){
        ArrayList<Employee> rs = employeeRepository.findAll();
        for (Employee e: rs) {
            System.out.println(e);
        }
    }
    public void printaddEmployee(Employee employee){
        ArrayList<Employee> rs = employeeRepository.save(employee);
        for (Employee e:rs) {
            System.out.println(e);
        }
    }
    public void printfindByName(String name) {
        for (Employee e: employeeRepository.findByNameContainsIgnoreCase(name)) {
            System.out.println(e);
        }
    }
    public void printfindbyId(int id) {
        System.out.println(employeeRepository.findById(id));
    }
    public void printdeletebyId(int id) {
        ArrayList<Employee> rs = employeeRepository.deleteById(id);
        for (Employee e:rs) {
            System.out.println(e);
        }
    }
    public void printfindbySalary(){
        System.out.println(employeeRepository.findBySalary(5000000,10000000));
    }
}

