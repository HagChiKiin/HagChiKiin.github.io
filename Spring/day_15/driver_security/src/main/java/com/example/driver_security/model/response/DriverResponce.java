package com.example.driver_security.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonInclude(JsonInclude.Include.NON_NULL)

public class DriverResponce  {
    int id;
    String name;
    String address;
    String phone;
    String level;

    String username;

    Set<RoleResponse> roles;
}
