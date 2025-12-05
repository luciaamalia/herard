package com.herard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "trophy")
@Data
public class Trophy {

    @Id
    private Integer id;

    @Column
    private User user;

    @Column
    private  String name;

    @Column
    private  Habit Habit;

    @Column
    private LocalDateTime createdAt;
}
