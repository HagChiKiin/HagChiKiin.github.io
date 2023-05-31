package com.example.bt_employee;

import com.example.bt_employee.entity.Employee;
import com.example.bt_employee.repository.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class BtEmployeeApplicationTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void save_user_list() {
        List<Employee> employees = List.of(
                new Employee(null, "Kiên", "Injection", 200000L, LocalDate.now()),
                new Employee(null, "Hải", "PT", 300000L, LocalDate.now()),
                new Employee(null, "Toàn", "QA", 400000L, LocalDate.now()),
                new Employee(null, "Tài", "Logictics", 500000L, LocalDate.now())
        );
        employeeRepository.saveAll(employees);
    }
}
