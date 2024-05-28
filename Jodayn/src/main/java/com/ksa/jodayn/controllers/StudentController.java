package com.ksa.jodayn.controllers;

import com.ksa.jodayn.dto.Student;
import com.ksa.jodayn.services.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("students")
public class StudentController {

    public final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @GetMapping
    public List<Student> getStudents() {
        return studentService.getSortedStudents();
    }

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(
                studentService.addStudent(student),
                HttpStatus.CREATED);
    }

}
