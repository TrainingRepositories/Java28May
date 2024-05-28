package com.ksa.jodayn.dto;

import com.ksa.jodayn.models.StudentEntity;
import lombok.Data;

@Data
public class Student {
    private Long id;
    private String name;
    private int age;

    public Student() {

    }

    public Student(Long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(StudentEntity entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
    }
}
