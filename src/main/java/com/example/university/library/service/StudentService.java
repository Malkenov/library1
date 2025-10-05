package com.example.university.library.service;

import com.example.university.library.exception.StudentNotFoundException;
import com.example.university.library.model.Student;
import com.example.university.library.repository.StudentRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import java.util.List;

public class StudentService {

    public StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentId(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Студент с " + id +" не найден!"));
    }

    public Student addNewStudent(Student student){
        return studentRepository.save(student);
    }



    public Student updateStudent(Long id, Student student){
        Student s = studentRepository.findById(id)
                        .orElseThrow(() -> new StudentNotFoundException("Студент с " + id +" не найден!"));
        s.setName(student.getName());
        s.setEmail(student.getEmail());
        s.setAge(student.getAge());
        return studentRepository.save(student);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
