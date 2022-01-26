package com.sp.sb.flash.repository;

import com.sp.sb.flash.entity.Course;
import com.sp.sb.flash.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository repository;

    @Test
    void saveCourseMaterial(){
        Course course = new Course("DSA",7);
        CourseMaterial material = new CourseMaterial("www.facebook.com", course);

        repository.save(material);
    }

    @Test
    void printALlMaterials(){
        List<CourseMaterial> materials = repository.findAll();
        System.out.println("materials = " + materials);
    }
}