package com.herard.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "habit")
public class Habit {

    @Id
    private Integer id;

    @Column
    private String name;

    private String description;

    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Boolean active = true;
}
