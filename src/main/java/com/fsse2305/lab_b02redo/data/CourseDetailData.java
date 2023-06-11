package com.fsse2305.lab_b02redo.data;

import com.fsse2305.lab_b02redo.data.dto.CourseDetailResponseDto;
import com.fsse2305.lab_b02redo.data.entity.CourseEntity;
import com.fsse2305.lab_b02redo.data.entity.PersonEntity;

import java.util.ArrayList;
import java.util.List;

public class CourseDetailData {
    private String courseId;
    private String name;
    private Double price;
    private PersonDetailDate teacher;
    private List<PersonDetailDate> students;

    public CourseDetailData(CourseEntity courseEntity){
        this.courseId = courseEntity.getCourseId();
        this.name = courseEntity.getName();
        this.price = courseEntity.getPrice();
        PersonDetailDate personDetailDate = new PersonDetailDate(courseEntity.getTeacher());
        this.teacher = personDetailDate;
        List<PersonDetailDate>  personDetailDateList = new ArrayList<>();
        if(!(courseEntity.getStudents()==null)) {
            for (PersonEntity personEntity : courseEntity.getStudents()) {
                PersonDetailDate student = new PersonDetailDate(personEntity);
                personDetailDateList.add(student);
            }
            this.students = personDetailDateList;
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
