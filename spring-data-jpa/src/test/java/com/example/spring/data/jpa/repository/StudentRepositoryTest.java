package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Guardian;
import com.example.spring.data.jpa.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

//Generated test class for the StudentRepository
//SpringBootTest does not flush the database after testing, in order to do that
//use DataJPATest instead,
@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudent(){
        Student student = Student.builder()
                .emailId("John@gmail.com")
                .firstName("John")
                .lastName("Doe")
                //guardianName("Jane")
                //.guardianEmail("Jane@gmail.com")
                //.guardianMobile("+4525432312")
                .build();

        studentRepository.save(student);
    }

    @Test
    void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("Jane@gmail.com")
                .name("Jane")
                .mobile("+4525432312")
                .build();

        Student student = Student.builder()
                .firstName("Cole")
                .emailId("cole@gmail.com")
                .lastName("Jackson")
                .guardian(guardian) //refers back to the guardian object
                .build();

        studentRepository.save(student);
    }

    //region TestGetMethods
    @Test
    void printAllStudents(){
        List<Student> studentList =
                studentRepository.findAll();

        System.out.println("studentList = " + studentList); //soutv
    }

    @Test
    void printStudentByFirstName(){
        List<Student> students =
                studentRepository.findByFirstName("john");
        System.out.println("students = " + students);
    }

    @Test
    void printStudentByFirstNameContaining(){
        List<Student> students =
                studentRepository.findByFirstNameContaining("j");
        System.out.println("students = " + students);
    }

    @Test
    void printGetStudentByEmailAddress(){
        Student student =
                studentRepository.getStudentByEmailAddress(
                        "cole@gmail.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    void printGetStudentFirstNameByEmailAddress(){
        String firstName =
                studentRepository.getStudentFirstNameByEmailAddress(
                        "John@gmail.com"
                );
        System.out.println("firstName = " + firstName);
    }

    @Test
    void printGetStudentByEmailAddressNative(){
        Student student =
                studentRepository.getStudentByEmailAddressNative(
                        "cole@gmail.com"
                );
        System.out.println("student = " + student);
    }

    @Test
    void printGetStudentByEmailAddressNativeNamedParam(){
        Student student =
                studentRepository.getStudentByEmailAddressNativeNamedParam(
                        "cole@gmail.com"
                );
        System.out.println("student = " + student);
    }
    //endregion

    @Test
    void updateStudentNameByEmailIdTest(){
        studentRepository.updateStudentNameByEmailId(
                "coleslaw",
                "cole@gmail.com"
        );
    }
}