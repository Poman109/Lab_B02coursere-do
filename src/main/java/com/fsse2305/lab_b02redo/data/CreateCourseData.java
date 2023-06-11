package com.fsse2305.lab_b02redo.data;

import com.fsse2305.lab_b02redo.data.dto.CreateCourseRequestDto;

public class CreateCourseData {
    private String courseId;
    private String name;
    private Double price;
    private String teacherHkid;

    public CreateCourseData(CreateCourseRequestDto createCourseRequestDto){
        this.courseId = createCourseRequestDto.getCourseId();
        this.name = createCourseRequestDto.getName();
        this.price = createCourseRequestDto.getPrice();
        this.teacherHkid = createCourseRequestDto.getTeacherHkid();
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

    public String getTeacherHkid() {
        return teacherHkid;
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

    public void setTeacherHkid(String teacherHkid) {
        this.teacherHkid = teacherHkid;
    }
}
