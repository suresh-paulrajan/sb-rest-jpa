package com.sp.sb.flash.repository;

import com.sp.sb.flash.entity.Course;
import com.sp.sb.flash.entity.Guardian;
import com.sp.sb.flash.entity.Student;
import com.sp.sb.flash.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    void listAllCourses(){
        List<Course> courseList = repository.findAll();
        System.out.println("courseList = " + courseList);
    }

    @Test
    void saveCourseWithTeacher(){
        Guardian guardian = new Guardian("guard_name", "guard_email@email.com","9999999999");
        Student venki = new Student("Venki", "KK", "venkiii@email.com", LocalDate.of(1992, Month.MAY, 23));
        venki.setGuardian(guardian);
        Teacher teacher = new Teacher("Vijay","Kumar");
        Course course = new Course("AI",10, teacher);
        course.addStudents(venki);

        repository.save(course);
    }

    @Test
    void findWithPagination(){
        Pageable firstPageWithThreeRecords = PageRequest.of(0,3);
        Pageable secondPageWithTwoRecords = PageRequest.of(1,2);
        
        List<Course> courseList = repository.findAll(secondPageWithTwoRecords).getContent();
        System.out.println("courseList = " + courseList);
    }

    @Test
    void findWithSorting(){
        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));
        Pageable sortByCreditDesc = PageRequest.of(0,2, Sort.by("credit").descending());

        List<Course> courseList = repository.findAll(sortByTitle).getContent();
        System.out.println("courseList = " + courseList);

        List<Course> courseList2 = repository.findAll(sortByCreditDesc).getContent();
        System.out.println("courseList2 = " + courseList2);
    }

    @Test // ManyToMany
    void saveCouseWithStudentAndTeacher(){
        Teacher teacher = new Teacher("Ruba","Anand");
        Course course = new Course("Laravel",7, teacher);
    }
}