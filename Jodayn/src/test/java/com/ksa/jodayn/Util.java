package com.ksa.jodayn;

import com.ksa.jodayn.dto.Student;
import com.ksa.jodayn.models.StudentEntity;

import java.util.ArrayList;
import java.util.List;

public class Util {
    public static List<StudentEntity> createStudentsEntities() {
        List<StudentEntity> studentsEntities = new ArrayList<>();
        studentsEntities.add(
                new StudentEntity(
                        new Student(
                                1L,
                                "Ziad",
                                48,
                                0
                        )
                ));
        studentsEntities.add(
                new StudentEntity(
                        new Student(
                                2L,
                                "Juman",
                                23,
                                0
                        )
                )
        );
        return studentsEntities;
    }
}
