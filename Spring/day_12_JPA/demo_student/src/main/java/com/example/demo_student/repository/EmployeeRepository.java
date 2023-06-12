package com.example.demo_student.repository;

import com.example.demo_student.dto.EmployeeDto;
import com.example.demo_student.entity.Employee;
import com.example.demo_student.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select new com.example.demo_student.dto.EmployeeDto(e.id, e.name , e.email) from Employee e where e.email= ?1 ")
    EmployeeDto getEmployeeDtoByEmail(String email);

    @Query(nativeQuery = true,name = "getEmployeeDtoUsingNQ")
    EmployeeDto getEmployeeDtoUsingNQ (String email);

}
