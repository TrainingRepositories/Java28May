package com.ksa.jodayn.services;

import com.ksa.jodayn.dto.Student;
import com.ksa.jodayn.models.StudentEntity;
import com.ksa.jodayn.repos.StudentRepo;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class StudentServiceImp implements StudentService {

    private final StudentRepo studentRepo;
    private final DateUtilService dateUtilService;

    public StudentServiceImp(StudentRepo studentRepo, DateUtilService dateUtilService) {
        this.studentRepo = studentRepo;
        this.dateUtilService = dateUtilService;
    }

    public List<Student> getSortedStudents() {
        List<Student> students = new java.util.ArrayList<>(StreamSupport.stream(studentRepo.findAll().spliterator(),
                false).map(se -> new Student(se, dateUtilService.calcYearOfBirth(se.getAge()))).toList());
        students.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        return students;
    }

    public Student addStudent(Student student) {
        return new Student(studentRepo.save(new StudentEntity(student)),
                dateUtilService.calcYearOfBirth(student.getAge()));
    }


}
