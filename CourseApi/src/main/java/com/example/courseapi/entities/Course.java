package com.example.courseapi.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Set; // Используем правильный импорт Set из java.util

@Entity
@Data
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 500)
    private String description;

    // Связь многие ко многим с правильным типом Set<Student>
    @ManyToMany
    @JoinTable(
            name = "course_student", // название промежуточной таблицы
            joinColumns = @JoinColumn(name = "course_id"), // столбец для связи с курсом
            inverseJoinColumns = @JoinColumn(name = "student_id") // столбец для связи со студентом
    )
    private Set<Student> students;

}
