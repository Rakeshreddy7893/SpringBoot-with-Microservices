package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
public List<Student> findByFirstName(String firstName);
List<Student> findByFirstNameContaining(String name);
List<Student>findByLastNameNotNull();
List<Student>findByGaurdianName(String gaurdianName);
Student findByFirstNameAndLastName(String firstName,String lastName);

//JPQL Query
@Query("select s from Student s where s.emailId= ?1")
Student getStudentByEmailAddress(String emailId);

//JPQL Query
@Query("select s.firstName from Student s where s.emailId= ?1")
String getStudentFirstNameByEmailAddress(String emailId);

//Native Queries
    @Query(value="select * from tbl_student s where s.email_address= ?1",nativeQuery = true)
    Student getStudentByEmailAddressNative(String emaild);


//NativeNamedParams
    @Query(value="select * from tbl_student s where s.email_address= :emailId",nativeQuery = true)
    Student getStudentByEmailAddressNativeNamedParams(@Param("emailId") String emaild);

    @Modifying
    @Transactional
    @Query(value = "update tbl_student set first_name=?1 where email_address=?2",nativeQuery = true)
    int updateStudentNameByEmailId(String firstName,String emailId);

}

