package com.ksa.jodayn.services;

import com.ksa.jodayn.dto.Student;
import com.ksa.jodayn.models.StudentEntity;
import com.ksa.jodayn.repos.StudentRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Calendar;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import static com.ksa.jodayn.Util.createStudentsEntities;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;


//https://www.baeldung.com/mockito-series

@ExtendWith(MockitoExtension.class)
class JodaynStudentServiceTests {


    @Mock
    private StudentRepo repo;

    @Spy
    private DateUtilService dateUtilService;

    @InjectMocks
    private StudentServiceImp studentService;

    @Test
    void getStudentsTest() {
        List<StudentEntity> testStudents = createStudentsEntities();
        when(repo.findAll()).thenReturn(testStudents);

        when(repo.findById(anyLong())).thenAnswer(invocationOnMock -> {
                    long id = invocationOnMock.getArgument(0);
                    return testStudents.stream().filter(student -> student.getId() == id)
                            .findFirst();
                }

        );

        Optional<StudentEntity> entity = repo.findById(2L);
        assert (entity.isPresent());
        assert (entity.get().getId() == 2L);


        List<StudentEntity> sortedStudents = new java.util.ArrayList<>(testStudents.stream().map(StudentEntity::new).toList());
        sortedStudents.sort(Comparator.comparing(StudentEntity::getName));
        List<Student> students = studentService.getSortedStudents();
        assert (students.size() == testStudents.size());
        assert (sortedStudents.get(0).getName().equals(students.get(0).getName()));
        Student firstStudent = students.get(0);
        int yearOfBirthForFirstStudent = Calendar.getInstance().get(Calendar.YEAR) - firstStudent.getAge();
        assert (firstStudent.getYearOfBirth() == yearOfBirthForFirstStudent);
    }


}
