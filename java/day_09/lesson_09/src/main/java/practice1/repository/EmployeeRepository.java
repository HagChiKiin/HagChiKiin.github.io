package practice1.repository;

import practice1.database.EmployeeDatabase;
import practice1.model.Employee;

import java.util.ArrayList;

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
        return null;
    }


    public ArrayList<Employee> deleteById(int id1){
        ArrayList<Employee> rs2 = new ArrayList<>();
        for (Employee g:EmployeeDatabase.employee) {
            if (g.getId()!=id1){
                rs2.add(g);

            }

        }
    return rs2;

    }
    public ArrayList<Employee> findBySalary(int minSalary, int maxSalary){
        ArrayList<Employee> rs3 = new ArrayList<>();
        for (Employee h :EmployeeDatabase.employee) {
            if(h.getSalary()>= minSalary && h.getSalary()<= maxSalary){
                rs3.add(h);
            }

        }
    return rs3;
    }
}
