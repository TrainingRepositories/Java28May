package com.ksa.jodayn.services;

import com.ksa.jodayn.dto.Student;
import com.ksa.jodayn.models.StudentEntity;
import com.ksa.jodayn.repos.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImp implements StudentService{

    private final StudentRepo studentRepo;

    public StudentServiceImp(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public List<Student> getStudents() {
        return StreamSupport.stream(studentRepo.findAll().spliterator(), false)
                .map(Student::new).toList();
    }

    public Student addStudent(Student student) {
        return new Student(studentRepo.save(new StudentEntity(student)));
    }
}
