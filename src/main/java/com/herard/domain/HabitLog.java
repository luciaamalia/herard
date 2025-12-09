package com.herard.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "habtlog")
@Data
public class HabitLog {

    @Id
    private Integer id;

    @Column
    private Habit habit;

    @Column
    private LocalDate date;

    @Column
    private  Boolean completed;

    //comente

}
