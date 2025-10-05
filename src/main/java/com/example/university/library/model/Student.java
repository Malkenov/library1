package com.example.university.library.model;


import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(unique = true)
    private String email;

    @Column(name = "age")
    private int age;

    @ManyToMany
    @JoinTable(
            name = "student_courses", // имя таблицы-связки
            joinColumns = @JoinColumn(name = "student_id"), // колонка для Student
            inverseJoinColumns = @JoinColumn(name = "course_id")) //колонка для Course
    private List<Course> courses = new ArrayList<>();

}
