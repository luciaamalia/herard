package com.herard.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "habit")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Buider
public class Habit {

    @Id
    @GeneratedValue
    private UUID id;

    //relacionamento -
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private  User user;

    @Column
    private String description;


    private Integer  targetDays;

    @Enumerated(EnumType.STRING)
    private Frequency frequency;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private Boolean active = true;


}
