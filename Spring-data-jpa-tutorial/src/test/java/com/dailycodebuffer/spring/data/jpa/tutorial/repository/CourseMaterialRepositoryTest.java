package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Course;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.CourseMaterail;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private  CourseMaterialRepository courseMaterialRepository;



    @Test
    public void saveCourseMaterail(){
        Course course = Course.builder().title("DSA").credit(6).build();
        CourseMaterail courseMaterail = CourseMaterail.builder().url("www.google.com").course(course).build();
        courseMaterialRepository.save(courseMaterail);
    }

    @Test
    public void printAllCoursesMaterials(){
        List<CourseMaterail> materailList = courseMaterialRepository.findAll();
        System.out.println("materailList = " + materailList);

    }
}