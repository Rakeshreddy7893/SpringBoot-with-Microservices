package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Gaurdian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private  StudentRepository studentRepository;


//    @Test
//    public void  saveStudent(){
//        Student student = Student.builder().
//                emaiId("Shabir@gmail.com")
//                .firstName("Shabir").
//                lastName("Dawoodi").
//               // gaurdianName("Nikhil").
//               // gaurdianEmail("nikhil@gmail.com").
//               // gaurdianMobile("9999999999").build();
//        studentRepository.save(student);
//    }

    @Test
    public void  saveStudentWithGuardian(){
        Gaurdian gaurdian = Gaurdian.
                builder().
                email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999999999")
                .build();

        Student student = Student.builder()
                .firstName("Shivam")
                .emailId("shivam@gmail.com")
                .lastName("Kumar")
                .gaurdian(gaurdian)
                .build();
        studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);

    }

    @Test
    public void printStudentByFirstName(){
    List<Student> studentList = studentRepository.findByFirstName("shivam");
        System.out.println("studentList = " + studentList);

    }
    
   
    @Test
    public void getStudentByChar(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("s");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public  void printStudentGaurdianName(){
        List<Student> studentList = studentRepository.findByGaurdianName("Nikhil");
        System.out.println("studentList = " + studentList);
    }
    @Test
   public  void  printStudentByEmailAddress(){
        Student studentList = studentRepository.getStudentByEmailAddress("Shabir@gmail.com");
        System.out.println("studentList = " + studentList);
   }

   @Test
   public  void printgetStudentFirstNameByEmailAddress(){
      String firstName = studentRepository.getStudentFirstNameByEmailAddress("shivam@gmail.com");
       System.out.println("firstName = " + firstName);
   }

   @Test
   public void getStudentByEmailAddressNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("shivam@gmail.com");
       System.out.println("student = " + student);
   }

    @Test
    public void getStudentByEmailAddressNativeNamedParams(){
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParams("shivam@gmail.com");
        System.out.println("student = " + student);
    }

    @Test
    public void updateStudentNameByEmailIdTest(){
     studentRepository.updateStudentNameByEmailId("Shabir dawoodi","Shabir@gmail.com");
    }


}