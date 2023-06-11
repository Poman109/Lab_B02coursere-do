package com.fsse2305.lab_b02redo.data.dto;

import java.util.List;

public class CourseDetailResponseDto {
    private String courseId;
    private String name;
    private Double price;
    private PersonDetailResponseDto teacher;
    private List<PersonDetailResponseDto> students;

    public String getCourseId() {
        return courseId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public PersonDetailResponseDto getTeacher() {
        return teacher;
    }

    public List<PersonDetailResponseDto> getStudents() {
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

    public void setTeacher(PersonDetailResponseDto teacher) {
        this.teacher = teacher;
    }

    public void setStudents(List<PersonDetailResponseDto> students) {
        this.students = students;
    }
}
