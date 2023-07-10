package com.example.tim_kiem_viec_lam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "jobSkills")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JobSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Long id;

    @ManyToOne(targetEntity = Job.class)
    @JoinColumn(name = "job_id")
    Job job;

    @ManyToOne(targetEntity = Skill.class)
    @JoinColumn(name = "skill_id")
    Skill skill;

}
