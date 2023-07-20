package com.example.tim_kiem_viec_lam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "skills")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Skill extends BaseEntity{

    @Column(name = "name")
    String name;
}
