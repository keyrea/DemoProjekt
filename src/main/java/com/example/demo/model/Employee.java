//Domain class for table
package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "employees")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "NUMERIC(19,0)")
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "email_address", nullable = false)
    private String emailId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    private Field field;

    @OneToMany(mappedBy = "employee")
    List<Employee2Course> employee2Courses;

}