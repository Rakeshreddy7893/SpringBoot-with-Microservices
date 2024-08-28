package com.recykal.Redis.controller;

import com.recykal.Redis.entity.Student;
import com.recykal.Redis.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StudentRestController {

    @Autowired
    private StudentRepository studentRepository;


    @GetMapping("/students")
    public Iterable<Student> getAllStudents(){
      return studentRepository.findAll();
    }


    @PostMapping("/student")
    public String addStudent(@RequestBody Student student){
        studentRepository.save(student);
        return "Student Saved";
    }
}

