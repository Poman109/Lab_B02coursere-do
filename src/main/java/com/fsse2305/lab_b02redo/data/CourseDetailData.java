package com.fsse2305.lab_b02redo.data;

import com.fsse2305.lab_b02redo.data.dto.CourseDetailResponseDto;

import java.util.List;

public class CourseDetailData {
    private String courseId;
    private String name;
    private Double price;
    private PersonDetailDate teacher;
    private List<PersonDetailDate> students;

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public PersonDetailDate getTeacher() {
        return teacher;
    }

    public List<PersonDetailDate> getStudents() {
        return students;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTeacher(PersonDetailDate teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<PersonDetailDate> students) {
        this.students = students;
    }
}
