package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "courses")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "NUMERIC(19,0)")
    private Long id;

    @Column(name="name",nullable = false)
    private String name;

    @OneToMany(mappedBy = "course")
    List<Employee2Course> employee2Courses;

}
