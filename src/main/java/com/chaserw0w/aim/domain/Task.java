package com.chaserw0w.aim.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;
    @Column(name = "isCompleted")
    private Boolean isCompleted;

    public Task(String name, Boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }
}


