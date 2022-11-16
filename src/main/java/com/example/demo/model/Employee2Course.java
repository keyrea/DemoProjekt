package com.example.demo.model;

import lombok.Data;
import javax.persistence.*;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees2courses")
@Data
public class Employee2Course {

    @EmbeddedId
    Employee2CourseCompositeKey id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employee_id")
    Employee employee;

    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    Course course;
}
