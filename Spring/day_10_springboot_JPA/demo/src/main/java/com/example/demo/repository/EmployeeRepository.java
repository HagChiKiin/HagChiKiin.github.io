package com.example.demo.repository;

import com.example.demo.entity.Employee;
import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(Long salary);

    List<Employee> findByName(String name);

    List<Employee> findByNameContainingIgnoreCase(String keyword);

    List<Employee> findByNameStartingWith(String prefix);

    List<Employee> findBySalaryBetween(Long minSalary, Long maxSalary);

    int countEmployeeByDepartment(String department);

    List<Employee> findByNameContainingIgnoreCaseAndDepartment(String keyword, String department);

    List<Employee> findByNameOrDepartment(String name, String department);

    List<Employee> findByJoiningDateAfter(LocalDate date);
}
