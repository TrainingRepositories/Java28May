package com.ksa.jodayn;

import com.ksa.jodayn.dto.Student;
import com.ksa.jodayn.models.StudentEntity;
import com.ksa.jodayn.repos.StudentRepo;
import com.ksa.jodayn.services.StudentService;
import com.ksa.jodayn.services.StudentServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;


//https://www.baeldung.com/mockito-series

@ExtendWith(MockitoExtension.class)
class JodaynStudentServiceTests {

    @Mock
    private StudentRepo repo;

    @InjectMocks
    private StudentServiceImp studentService;

    @Test
    void getStudentsTest() {
        when(repo.findAll()).thenReturn(createStudentsEntities());
        List<Student> students = studentService.getStudents();
        assert (students.size() == 2);
        assert ("Abd".equals(students.get(0).getName()));
    }

    private List<StudentEntity> createStudentsEntities() {
        List<StudentEntity> studentsEntities = new ArrayList<>();
        studentsEntities.add(
                new StudentEntity(
                        new Student(
                                1L,
                                "Abd",
                                48
                        )
                ));
        studentsEntities.add(
                new StudentEntity(
                        new Student(
                                2L,
                                "Juman",
                                23
                        )
                )
        );
        return studentsEntities;
    }

}
