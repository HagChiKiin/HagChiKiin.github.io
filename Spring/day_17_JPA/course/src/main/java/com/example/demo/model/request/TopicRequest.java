package com.example.demo.model.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TopicRequest {

    @Size(max = 100, message = "Name cannot over 100 characters")
    @NotBlank(message = "Topic name cannot be blank")
    String name;

}
