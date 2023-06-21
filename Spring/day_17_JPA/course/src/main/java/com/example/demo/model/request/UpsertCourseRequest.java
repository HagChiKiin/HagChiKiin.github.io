package com.example.demo.model.request;


import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UpsertCourseRequest {
    @NotBlank(message = "Name cannot be blank!")
    String name;

    @Size(min = 50, message = "Description cannot less than 50 characters")
    @NotBlank(message = "Description cannot be blank!")
    String description;

    @NotBlank(message = "type cannot be blank!")
    String type;

    List<Integer> topicIds;

    String thumbnail;

    Integer supporterId;
}
