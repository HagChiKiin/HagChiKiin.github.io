package com.example.demo_student;

import com.example.demo_student.dto.EmployeeDto;
import com.example.demo_student.entity.Employee;
import com.example.demo_student.mapper.EmployeeMapper;
import com.example.demo_student.repository.EmployeeRepository;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class EmployeeTest {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private Faker faker;


    @Test
    void save_em(){
        for (int i = 0; i < 10; i++) {
            Employee employee = Employee.builder()
                    .name(faker.name().fullName())
                    .email(faker.internet().emailAddress())
                    .password("123")
                    .build();
            employeeRepository.save(employee);

        }
    }
    @Test
    void query_dto_mapper(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = employeeList.stream()
                .map((employee -> EmployeeMapper.toEmployeeDto(employee)))
                .collect(Collectors.toList());
        employeeDtoList.forEach(System.out::println);
    }
    @Test
    void query_dto_model_mapper(){
        ModelMapper mapper = new ModelMapper();
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeDto> employeeDtoList = employeeList.stream()
                .map(employee -> mapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
        employeeDtoList.forEach(System.out::println);
    }

    @Test
    void query_dto_jpql(){
        EmployeeDto employeeDto = employeeRepository.getEmployeeDtoByEmail("carlena.herzog@hotmail.com");
        System.out.println(employeeDto);
    }
}
