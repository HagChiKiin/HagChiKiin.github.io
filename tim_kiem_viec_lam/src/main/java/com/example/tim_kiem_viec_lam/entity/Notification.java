package com.example.tim_kiem_viec_lam.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "notifications")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification extends BaseEntity {

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "from_to_id")
    User formUser;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "to_user_id")
    User toUser;

    @Column(name = "title")
    String title;

    @Column(name = "content")
    String content;


}
