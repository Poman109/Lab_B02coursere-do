package com.fsse2305.lab_b02redo.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateCourseRequestDto {
    @JsonProperty("course_id")
    private String CourseId;
    @JsonProperty("course_name")
    private String name;
    private Double price;
    @JsonProperty("teacher_hkid")
    private String teacherHkid;

    public String getCourseId() {
        return CourseId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getTeacherHkid() {
        return teacherHkid;
    }

    public void setCourseId(String courseId) {
        CourseId = courseId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setTeacherHkid(String teacherHkid) {
        this.teacherHkid = teacherHkid;
    }
}
