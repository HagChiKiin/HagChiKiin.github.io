package com.example.ktra_spring_web.entity;

import com.example.ktra_spring_web.statics.Status;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "appoitment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    Integer id;

    @OneToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "description")
    String description;

    @Column(name = "status")
    Status status;

    @Column(name = "created_at")
    LocalDateTime createdAt;

    @Column(name = "confirm_at")
    LocalDateTime confirmAt;

    @Column(name = "appointment_at")
    LocalDate appointmentAt;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        this.status = Status.PENDING;
    }

    @PreUpdate
    public void preUpdate() {
        this.confirmAt = LocalDateTime.now();
    }
}
