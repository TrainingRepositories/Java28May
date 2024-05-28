package com.ksa.jodayn.models;


import com.ksa.jodayn.dto.Student;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
public class StudentEntity {
    @Id
    private Long id;
    private String name;
    private int age;

    public StudentEntity() {

    }

    public StudentEntity(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.age = student.getAge();
    }
}
