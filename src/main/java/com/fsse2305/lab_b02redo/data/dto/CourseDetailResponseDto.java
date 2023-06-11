package com.fsse2305.lab_b02redo.data.dto;

import com.fasterxml.jackson.annotation.JsonKey;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.lab_b02redo.data.CourseDetailData;
import com.fsse2305.lab_b02redo.data.PersonDetailDate;

import java.util.ArrayList;
import java.util.List;

public class CourseDetailResponseDto {
    @JsonProperty("price")
    private Double price;
    @JsonProperty("teacher")
    private PersonDetailResponseDto teacher;
    @JsonProperty("students")
    private List<PersonDetailResponseDto> students;
    @JsonProperty("course_id")
    private String courseId;
    @JsonProperty("course_name")
    private String name;


    public CourseDetailResponseDto(CourseDetailData courseDetailData){
        this.courseId = courseDetailData.getCourseId();
        this.name = courseDetailData.getName();
        this.price = courseDetailData.getPrice();
        PersonDetailResponseDto teacher = new PersonDetailResponseDto(courseDetailData.getTeacher());
        this.teacher = teacher;
        List<PersonDetailResponseDto> studentsArray = new ArrayList<>();
        if(!(courseDetailData.getStudents()==null)){
            for (PersonDetailDate personDetailDate: courseDetailData.getStudents()){
                PersonDetailResponseDto student = new PersonDetailResponseDto(personDetailDate);
                studentsArray.add(student);
            }
            this.students = studentsArray;
        }



    }

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
