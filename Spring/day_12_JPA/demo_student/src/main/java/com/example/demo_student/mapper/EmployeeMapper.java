package com.example.demo_student.mapper;

import com.example.demo_student.dto.EmployeeDto;
import com.example.demo_student.entity.Employee;

public class EmployeeMapper {
    public static EmployeeDto toEmployeeDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .build();

    }
}
