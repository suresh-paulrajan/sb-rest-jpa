package com.sp.sb.flash.service;

import com.sp.sb.flash.entity.Student;
import com.sp.sb.flash.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
//        Optional<Student> studentOptional = studentRepository.findStudentByEmail(student.getEmail());
//        if(studentOptional.isPresent()){
//            throw new IllegalStateException("Email already taken");
//        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if(!exists){
            throw new IllegalStateException("Student with id - "+studentId+" does not exist !");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void updateStudent(Long id, String name, String email) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Student with id - "+id+" does not exist"));
        if(name != null && name.length() > 0
            && !Objects.equals(student.getFirstName(), name)){
            student.setFirstName(name);
        }
//        if(email != null && email.length() > 0
//                && !Objects.equals(student.getEmail(), email)){
//            Optional<Student> optionalStudent = studentRepository.findStudentByEmail(email);
//            if(optionalStudent.isPresent()){
//                throw  new IllegalStateException("Email already taken");
//            }
//            student.setEmail(email);
//        }
        student.setEmail(email);
    }
}
