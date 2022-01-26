package com.sp.sb.flash.repository;

import com.sp.sb.flash.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> findStudentByEmail(String email);
    Optional<Student> findStudentByFirstNameContaining(String name);
    Optional<Student> findByGuardianNameNotNull();

    // JPQL
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmailQuery(String email);

    // Native
    @Query(
            nativeQuery = true,
            value = "SELECT * FROM student s WHERE s.email=?1"
    )
    Optional<Student> findStudentByEmailQueryNative(String email);
}
