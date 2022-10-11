package com.example.spring.data.jpa.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterial {

    @Id
    @SequenceGenerator(
            name = "course_material_sequence",
            sequenceName = "course_material_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "course_material_sequence"
    )
    private Long courseMaterialId;
    private String url;

    //defining 1-1 relationship
    @OneToOne(
            cascade = CascadeType.ALL,
            //Lazy only returns CourseMaterial when fetching,
            // whereas Eager also returns the parent, i.e. Course
            fetch = FetchType.LAZY,
            //it should NOT be possible to save an instance of courseMaterial,
            //without also specifying the course
            optional = false

    )
    //defining FK reference
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;
}
