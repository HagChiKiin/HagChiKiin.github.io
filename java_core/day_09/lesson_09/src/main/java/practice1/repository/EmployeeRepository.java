package practice1.repository;

import practice1.database.EmployeeDatabase;
import practice1.exception.InValidSalaryException;
import practice1.exception.NotFoundException;
import practice1.model.Employee;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class EmployeeRepository {
    public ArrayList<Employee> findAll() {
        return EmployeeDatabase.employee;
    }

    public ArrayList<Employee> save(Employee employee) {
        EmployeeDatabase.employee.add(employee);
        return EmployeeDatabase.employee;
    }

    public ArrayList<Employee> findByNameContainsIgnoreCase(String name) {
        ArrayList<Employee> rs = new ArrayList<>();
        for (Employee e : EmployeeDatabase.employee) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                rs.add(e);
            }
        }
        return rs;
    }

    public Employee findById(int id) {
        for (Employee f:EmployeeDatabase.employee){
            if(f.getId()==id){
                return  f;
            }
        }
        throw new NotFoundException("Not found employee with id = " + id);

    }


    public ArrayList<Employee> deleteById(int id1){
        ArrayList<Employee> rs2 = new ArrayList<>();
        for (Employee g:EmployeeDatabase.employee) {
            if (g.getId()!=id1){
                rs2.add(g);
            }
        }
    return rs2;
        // Employee employee = findByid(id);
        // EmployeeDatabase.employee.remove(employee);
        // removeIf(e -> e.get(id) == id);

    }
    public ArrayList<Employee> findBySalary(int minSalary, int maxSalary){
        if(minSalary >= maxSalary){
            throw new InValidSalaryException("minSalary không được >= maxSalary");
        }
        ArrayList<Employee> rs3 = new ArrayList<>();
        for (Employee h :EmployeeDatabase.employee) {
            if(h.getSalary()>= minSalary && h.getSalary()<= maxSalary){
                rs3.add(h);
            }
        }
//        ArrayList<Employee> rs = (ArrayList<Employee>) EmployeeDatabase.employee.stream()
//                .filter(e -> e.getSalary() >= minSalary && e.getSalary() <= maxSalary)
//                .collect(Collectors.toList());
    return rs3;
    }

}
