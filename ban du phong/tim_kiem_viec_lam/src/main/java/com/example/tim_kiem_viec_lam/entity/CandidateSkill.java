package com.example.tim_kiem_viec_lam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "candidateSkills")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CandidateSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne(targetEntity = Candidate.class)
    @JoinColumn(name = "candidate_id")
    Candidate candidate;

    @ManyToOne(targetEntity = Skill.class)
    @JoinColumn(name = "skill_id")
    Skill skill;

}
