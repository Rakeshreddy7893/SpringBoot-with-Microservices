package com.dailycodebuffer.spring.data.jpa.tutorial.entity;

import com.dailycodebuffer.spring.data.jpa.tutorial.repository.CourseRepository;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Course {

    @Id
    @SequenceGenerator(name="course_sequence",sequenceName = "course_sequence",allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator ="course_sequence")
    private Long courseId;
    private String title;
    private Integer credit;

    @OneToOne(mappedBy ="course" )
    private CourseMaterail courseMaterail;

    @ManyToOne
    @JoinColumn(
         name="teacher_id",
         referencedColumnName = "teacherId"
    )
    private  Teacher teacher;

}
