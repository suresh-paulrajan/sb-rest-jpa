package com.sp.sb.flash.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "unique_student_email", columnNames = "email"))
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="first_name", nullable = false, columnDefinition = "TEXT")
    private String firstName;
    @Column(name="last_name", nullable = false, columnDefinition = "TEXT")
    private String lastName;
    @Column(nullable = false)
    private String email;
    @Transient
    private Integer age;
    private LocalDate dob;

    @Embedded
    private Guardian guardian;

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public Student(String firstName, String lastName, String email, LocalDate dob) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
    }

    public Student(String firstName, String lastName, String email, LocalDate dob, Guardian guardian) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.guardian = guardian;
    }

    public Student(Long id, String firstName, String lastName, String email, Integer age, LocalDate dob) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
        this.dob = dob;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return Period.between(this.dob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Guardian getGuardian() {
        return guardian;
    }

    public void setGuardian(Guardian guardian) {
        this.guardian = guardian;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dob=" + dob +
                '}';
    }
}
