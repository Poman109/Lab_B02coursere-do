package com.fsse2305.lab_b02redo.service;

import com.fsse2305.lab_b02redo.data.CourseDetailData;
import com.fsse2305.lab_b02redo.data.CreateCourseData;
import com.fsse2305.lab_b02redo.data.PersonDetailDate;
import com.fsse2305.lab_b02redo.data.entity.CourseEntity;
import com.fsse2305.lab_b02redo.service.impl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService implements CourseServiceImpl {

    private static List<CourseEntity> courseEntityArray = new ArrayList<>();


    private final PersonService personService;
    @Autowired
    public CourseService (PersonService personService) {
        this.personService = personService;
    }


    public CourseDetailData createCourse(CreateCourseData createCourseData){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(createCourseData.getCourseId());
        courseEntity.setName(createCourseData.getName());
        courseEntity.setPrice(createCourseData.getPrice());
        courseEntity.setTeacher(personService.getCourseTeacher(createCourseData.getTeacherHkid()));
        courseEntityArray.add(courseEntity);


        CourseDetailData courseDetailData = new CourseDetailData(courseEntity);

//        Lv1
//        courseDetailData.setCourseId(courseEntity.getCourseId());
//        courseDetailData.setName(courseEntity.getName());
//        courseDetailData.setPrice(courseEntity.getPrice());
//        PersonDetailDate teacher = new PersonDetailDate(courseEntity.getTeacher());
//        courseDetailData.setTeacher(teacher);


        return courseDetailData;
    }



}
