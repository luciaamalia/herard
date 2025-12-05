package com.herard.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "user")
@Data
public class User {

    @Id
    private  Integer id;

    @Column
    private  String name;

    @Column
    private  String email;

    @Column
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "user")
    private List<Habit> habits;
}
