package com.example.demo_student.entity;

import com.example.demo_student.dto.EmployeeDto;
import jakarta.persistence.*;
import lombok.*;
@SqlResultSetMappings(value = {
        @SqlResultSetMapping(
                name = "resultInfo",
                classes = @ConstructorResult(
                        targetClass = EmployeeDto.class,
                        columns = {
                                @ColumnResult(name = "id"),
                                @ColumnResult(name = "name"),
                                @ColumnResult(name = "email"    )
                        }
                )
        )
})
@NamedNativeQuery(
        name = "getEmployeeDtoUsingNQ",
        resultSetMapping = "",
        query = "select id,name,email from employee where email = ?1")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String email;

    private String password;

}
