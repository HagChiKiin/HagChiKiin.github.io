package com.example.bt_employee.repository;

import com.example.bt_employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Method JPA:
    List<Employee> findByDepartment(String department);

    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE department = ?1", nativeQuery = true)
    List<Employee> findByDepartment1(String department);

    // Method JPA:
    List<Employee> findBySalaryGreaterThan(Long salary);

    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE salary > ?1", nativeQuery = true)
    List<Employee> findBySalaryGreaterThan1(Long salary);

    // Method JPA:
    List<Employee> findByName(String name);

    // Native Query:
    @Query(value = "SELECT * FROM employee WHERE name = ?1", nativeQuery = true)
    List<Employee> findByName1(String name);

    List<Employee> findByNameContainingIgnoreCase(String keyword);

    @Query(value = "SELECT * FROM employee WHERE LOWER(name) LIKE CONCAT('%', LOWER(?1), '%')", nativeQuery = true)
    List<Employee> finhByNameContainingIgnoreCase1(String keyword);

    List<Employee> findByNameStartingWith(String prefix);

    @Query(value = "SELECT * FROM employee WHERE name LIKE CONCAT(?1, '%')", nativeQuery = true)
    List<Employee> findByNameStartingWith1(String prefix);

    List<Employee> findBySalaryBetween(Long minSalary, Long maxSalary);

    @Query(value = "SELECT * FROM employee WHERE salary BETWEEN ?1 AND ?2", nativeQuery = true)
    List<Employee> findBySalaryBetween1(Long minSalary, Long maxSalary);

    int countByDepartment(String department);

    @Query(value = "SELECT COUNT(*) FROM employee WHERE department = ?1", nativeQuery = true)
    int countByDepartment1(String department);

    List<Employee> findByNameContainingIgnoreCaseAndDepartment(String keyword, String department);

    @Query(value = "SELECT * FROM employee WHERE LOWER(name) LIKE CONCAT('%', LOWER(?1), '%') AND department = ?2", nativeQuery = true)
    List<Employee> findByNameContainingIgnoreCaseAndDepartment1(String keyword, String department);

    List<Employee> findByNameOrDepartment(String name, String department);

    @Query(value = "SELECT * FROM  employee WHERE name = ?1 or department = ?2", nativeQuery = true)
    List<Employee> findByNameOrDepartment1(String name, String department);

    List<Employee> findByJoiningDateAfter(LocalDate date);

    @Query(value = "SELECT * FROM employee WHERE joining_date > ?1", nativeQuery = true)
    List<Employee> findByJoiningDateAfter1(LocalDate date);
}

