package com.sp.sb.flash.repository;

import com.sp.sb.flash.entity.Course;
import com.sp.sb.flash.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository repository;

    @Test
    void saveTeacher(){
        /*Course css = new Course("CSS", 5);
        Course html = new Course("HTML", 6);
        Course angular = new Course("Angular", 8);
        Teacher teacher = new Teacher("Maths", "Miss", List.of(css,html,angular));*/
        Teacher teacher = new Teacher("Maths", "Miss");
        repository.save(teacher);
    }
}