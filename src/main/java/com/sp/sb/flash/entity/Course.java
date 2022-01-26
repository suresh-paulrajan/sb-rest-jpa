package com.sp.sb.flash.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String title;
    private Integer credit;

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", title='" + title + '\'' +
                ", credit=" + credit +
                ", material=" + courseMaterial +
                '}';
    }

    @OneToOne(
            mappedBy = "course"
    )
    private CourseMaterial courseMaterial;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name = "teacher_id",
            referencedColumnName = "teacherId"
    )
    private Teacher teacher;

    @ManyToMany(
            cascade = CascadeType.ALL
    )
    @JoinTable(
            name = "student_course_mapping",
            joinColumns = @JoinColumn(
                    name = "course_id",
                    referencedColumnName = "courseId"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "id",
                    referencedColumnName = "id"
            )
    )
    private List<Student> students;

    public void addStudents(Student student){
        if(students == null){
            students = new ArrayList<>();
        }
        students.add(student);
    }

    public Course(Long courseId, String title, Integer credit) {
        this.courseId = courseId;
        this.title = title;
        this.credit = credit;
    }

    public Course(String title, Integer credit) {
        this.title = title;
        this.credit = credit;
    }

    public Course(String title, Integer credit, Teacher teacher) {
        this.title = title;
        this.credit = credit;
        this.teacher = teacher;
    }

    public Course() {
    }

    public Long getCourseId() {
        return courseId;
    }

    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }
}
