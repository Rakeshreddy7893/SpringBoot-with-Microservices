package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = "course")
public class CourseMaterail {

    @Id
    @SequenceGenerator(name="course_materail_sequence",sequenceName = "course_materail_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "course_materail_sequence")
    private Long courseMaterialId;
    private String url;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY,optional = false)
    @JoinColumn(name="course_id",referencedColumnName ="courseId")
    private  Course course;
}
