package com.fsse2305.lab_b02redo.service.impl;

import com.fsse2305.lab_b02redo.data.CourseDetailData;
import com.fsse2305.lab_b02redo.data.CreateCourseData;
import com.fsse2305.lab_b02redo.data.UpdateCourseData;

import java.util.List;

public interface CourseServiceImpl {

    CourseDetailData createCourse(CreateCourseData createCourseData);
    List<CourseDetailData> getAllCourseDetails();

    CourseDetailData updateCourseData (UpdateCourseData updateCourseData);

    public CourseDetailData deleteCourse(String courseId);

    public CourseDetailData addStudent(String courseId,String hkid);

    public CourseDetailData deleteStudent(String courseId, String hkid);
}
