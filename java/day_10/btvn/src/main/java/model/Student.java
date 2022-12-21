package model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private double point;
    private String classroom;

}
