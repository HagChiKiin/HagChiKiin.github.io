package com.example.bt_driver.model.responce;

import com.example.bt_driver.model.request.PersonCreateRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DriverResponce  {
    int id;
    String name;
    String address;
    String phone;
    String level;

}
