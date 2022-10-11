package com.example.spring.data.jpa.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//Use Table annotation to specify mysql name, constraints, etc. for created table
@Table(name = "tbl_student",
        uniqueConstraints = @UniqueConstraint(
                name = "emailId_unique",
                columnNames = "email_address"
        ))
public class Student {

    @Id
    //Use SequenceGenerator and GeneratedValue annotations to specify how to
    // auto-increment Id with every new table insert

    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "student_sequence"
    )
    private Long studentId;
    private String firstName;
    private String lastName;
    //Use Column annotation to specify mysql name, nullability, etc. for created column
    @Column(
            name = "email_address",
            nullable = false)
    private String emailId;

    @Embedded
    private Guardian guardian;
}
