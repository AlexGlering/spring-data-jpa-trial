package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Course;
import com.example.spring.data.jpa.entity.Student;
import com.example.spring.data.jpa.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    void printCourses(){
        List<Course> courses =
                courseRepository.findAll();
        System.out.println("courses = " + courses);

    }

    @Test
    void saveCourseWithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("Carl")
                .lastName("Johnson")
                .build();

        Course course = Course.builder()
                .title("Python")
                .credit(6)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    void saveCourseWithStudentAndTeacher(){
        Course course = Course.builder()
                .title("AI")
                .credit(12)
                .teacher(Teacher.builder()
                        .firstName("James")
                        .lastName("Heimlich")
                        .build())
                .build();
        course.addStudents(Student.builder()
                        .firstName("Hans")
                        .lastName("Madsen")
                        .emailId("hans@gmail.com")
                        .build());

        courseRepository.save(course);
    }
}