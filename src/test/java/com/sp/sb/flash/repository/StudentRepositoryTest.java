package com.sp.sb.flash.repository;

import com.sp.sb.flash.entity.Guardian;
import com.sp.sb.flash.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Test
    void createStudent(){
        Guardian guardian = new Guardian("guard_name", "guard_email@email.com","9999999999");
        Student vikki = new Student("Vignesh", "Kumar", "vignesh2@email.com", LocalDate.of(1992, Month.MAY, 23));
        vikki.setGuardian(guardian);
        repository.save(vikki);
    }

    @Test
    void listStudents(){
        List<Student> studentsList = repository.findAll();
        System.out.println("studentsList = " + studentsList);
    }

    @Test
    void findStudentByEmail(){
        Optional<Student> studentList = repository.findStudentByEmail("suresh@email.com");
        System.out.println("studentList = " + studentList);
    }
    
    @Test
    void findStudentByFirstNameLike(){
        Optional<Student> studentList = repository.findStudentByFirstNameContaining("Sure");
        System.out.println("studentList = " + studentList);
    }

    @Test
    void findStudentsWithGuardianName(){
        Optional<Student> studentsList = repository.findByGuardianNameNotNull();
        System.out.println("studentsList = " + studentsList);
    }

    @Test
    void printStudentByEmailQuery(){
//        Optional<Student> student = repository.findStudentByEmailQuery("suresh@email.com");
        Optional<Student> student = repository.findStudentByEmailQueryNative("suresh@email.com");
        System.out.println("student = " + student);
    }
}