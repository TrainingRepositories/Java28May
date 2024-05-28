package com.ksa.jodayn.services;

import com.ksa.jodayn.dto.Student;

import java.util.List;

public interface StudentService {
     List<Student> getSortedStudents();
    Student addStudent(Student student);
}
