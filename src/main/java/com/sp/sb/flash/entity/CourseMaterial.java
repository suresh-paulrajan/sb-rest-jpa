package com.sp.sb.flash.entity;

import javax.persistence.*;

@Entity
public class CourseMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseMaterialId;
    private String url;

    @Override
    public String toString() {
        return "CourseMaterial{" +
                "courseMaterialId=" + courseMaterialId +
                ", url='" + url + '\'' +
//                ", course=" + course +
                '}';
    }

    @OneToOne(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            optional = false
    )
    @JoinColumn(
            name = "course_id",
            referencedColumnName = "courseId"
    )
    private Course course;

    public CourseMaterial() {
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public CourseMaterial(String url, Course course) {
        this.course = course;
        this.url = url;
    }

    public CourseMaterial(String url) {
        this.url = url;
    }

    public Long getCourseMaterialId() {
        return courseMaterialId;
    }

    public void setCourseMaterialId(Long courseMaterialId) {
        this.courseMaterialId = courseMaterialId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
