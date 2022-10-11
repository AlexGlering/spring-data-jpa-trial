package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void saveTeacher(){

        Course courseSDA =
                Course.builder()
                        .title("SDA")
                        .credit(5)
                        .build();
        Course courseOOP =
                Course.builder()
                        .title("OOP")
                        .credit(6)
                        .build();
        Course courseCPS =
                Course.builder()
                        .title("CPS")
                        .credit(4)
                        .build();

        Teacher teacher =
                Teacher.builder()
                        .firstName("Kenny")
                        .lastName("McCormick")
                        //.courses(List.of(courseSDA, courseCPS, courseOOP))
                        .build();

        teacherRepository.save(teacher);
    }
}