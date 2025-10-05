package com.example.university.library.service;

import com.example.university.library.exception.CoursNotFoundException;
import com.example.university.library.model.Course;
import com.example.university.library.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    public CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    public List<Course> getAllCourse() {
        return courseRepository.findAll();
    }

    public Course getById(Integer id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new CoursNotFoundException("Нету такого курса под номером " + id));
    }

    public Course addCourse(Course course) {
        return courseRepository.save(course);
    }

    public void deleteCourse(Integer id) {
        if (courseRepository.existsById(id)) {
            courseRepository.deleteById(id);
        } else {
            throw new CoursNotFoundException("Нету такого курса");
        }
    }
}
