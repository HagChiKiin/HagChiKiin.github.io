package com.example.demo_student.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeDto {
    private Integer id;
    private String name;
    private String email;

    // C1: query entity -> mapper-> dto
    // mapper có thể tự viết hoặc sử dụng thư viện bên ngoài : Object Mapper, Mapstruc
    // C2:sử dung JPQL
    // C3: sử dụng Native Query
    // c4: sử dụng projection (interface) -> tự tìm hiểi

}
