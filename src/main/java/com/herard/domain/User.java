package com.herard.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
//@Buider -- rever
public class User {

    @Id
    @GeneratedValue
    private UUID id;

    @Column
    private  String name;

    @Column
    private  String email;

    @Column
    private LocalDateTime createdAt;

    // Relacionamento 1..* com Habit
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Habit> habits;

    public List<Habit> getHabits() {
        return habits;
    }
}
