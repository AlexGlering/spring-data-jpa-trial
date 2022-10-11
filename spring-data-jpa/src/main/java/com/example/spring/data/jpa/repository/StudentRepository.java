package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//JPARepository interface takes an entity and ID-type. Here: Student and Long(ID)
//The repository is the interface from which the RESTapi gets its methods. See: spring-api-tutorial project
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {


    //region GetMethods
    //defining custom methods (no implementation needed)
    List<Student> findByFirstName(String firstName);

    //finds student by the letters contained in firstName parameter
    List<Student> findByFirstNameContaining(String name);

    //for methods check docs.spring.io/spring-data/jpa/docs/2.5.1/reference/html/#jpa.query-methods

    //Creating method and specifying query (JPQL) Based on created classes, not the database tables
    @Query("select s from Student s where s.emailId = ?1")
    Student getStudentByEmailAddress(String emailId);

    @Query("select s.firstName from Student s where s.emailId = ?1")
    String getStudentFirstNameByEmailAddress(String emailId);

    //Creating method and specifying query (Native Queries)
    @Query(
            //Ignore error message
            value = "SELECT * FROM tbl_student s WHERE s.email_address = ?1",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNative(String emailId);


    //Creating method and specifying query (Native Queries) with named parameter
    @Query(
            //Ignore error message
            value = "SELECT * FROM tbl_student s WHERE s.email_address = :emailId",
            nativeQuery = true
    )
    Student getStudentByEmailAddressNativeNamedParam(@Param("emailId") String emailId);
    //endregion

    //UpdateMethod
    @Modifying
    @Transactional
    @Query(
            //Ignore error message
            value = "update tbl_student set first_name =?1 where email_address = ?2",
            nativeQuery = true
    )
int updateStudentNameByEmailId(String firstName, String emailId);

}
