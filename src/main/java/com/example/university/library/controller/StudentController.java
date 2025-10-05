package com.example.university.library.controller;

import com.example.university.library.model.Student;
import com.example.university.library.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class StudentController {

    public  StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable Long id){
        return studentService.getStudentId(id);
    }

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addNewStudent(student);
    }

    @PutMapping
    public Student updateStudent(@PathVariable Long id,@RequestBody Student student){
        return studentService.updateStudent(id,student);
    }

    @DeleteMapping("/{id}")
    public void removeStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
    }
}
