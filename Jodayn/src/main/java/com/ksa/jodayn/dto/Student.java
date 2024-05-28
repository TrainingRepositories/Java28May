package com.ksa.jodayn.dto;

import com.ksa.jodayn.models.StudentEntity;
import lombok.Data;

@Data
public class Student {
    private Long id;
    private String name;
    private int age;

    public Student(StudentEntity entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.age = entity.getAge();
    }
}
