package com.example.university.library.controller;


import com.example.university.library.model.Course;
import com.example.university.library.model.Student;
import com.example.university.library.service.CourseService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    public CourseService courseService;

    public CourseController(CourseService courseService){
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAllStudents(){
        return courseService.getAllCourse();
    }

    @GetMapping("/{id}")
    public Course getStudentById(@PathVariable Integer id){
        return courseService.getById(id);
    }

    @PostMapping
    public Course addStudent(@RequestBody Course course){
        return courseService.addCourse(course);
    }


    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable Integer id){
        courseService.deleteCourse(id);
    }
}
