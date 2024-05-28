package com.ksa.jodayn.dto;

import com.ksa.jodayn.models.StudentEntity;
import lombok.Data;

@Data
public class Student {
    private Long id;
    private String name;
    private int age;
    private int yearOfBirth;

    public Student() {

    }

    public Student(Long id, String name, int age, int yearOfBirth) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.yearOfBirth = yearOfBirth;
    }

    public Student(StudentEntity entity, int yearOfBirth) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
        this.yearOfBirth = yearOfBirth;
    }
}
