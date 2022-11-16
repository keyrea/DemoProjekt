package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigInteger;

@Data
@Embeddable
public class Employee2CourseCompositeKey implements Serializable {

    @Column(name = "employee_id")
    BigInteger employee_id;

    @Column(name = "course_id")
    BigInteger course_id;
}
