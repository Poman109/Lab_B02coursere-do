package com.fsse2305.lab_b02redo.api;

import com.fsse2305.lab_b02redo.data.CourseDetailData;
import com.fsse2305.lab_b02redo.data.CreateCourseData;
import com.fsse2305.lab_b02redo.data.dto.CourseDetailResponseDto;
import com.fsse2305.lab_b02redo.data.dto.CreateCourseRequestDto;
import com.fsse2305.lab_b02redo.data.dto.PersonDetailResponseDto;
import com.fsse2305.lab_b02redo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CourseApi {
    private final CourseService courseService;
    @Autowired
    public CourseApi(CourseService courseService){
        this.courseService = courseService;
    }


    @PostMapping("/course")
    public CourseDetailResponseDto createCourse(@RequestBody CreateCourseRequestDto createCourseRequestDto){
        CreateCourseData createCourseData = new CreateCourseData(createCourseRequestDto);
        CourseDetailData courseDetailData = courseService.createCourse(createCourseData);


//        Lv1
//        courseDetailResponseDto.setCourseId(courseDetailData.getCourseId());
//        courseDetailResponseDto.setName(courseDetailData.getName());
//        courseDetailResponseDto.setPrice(courseDetailData.getPrice());
//        PersonDetailResponseDto teacher = new PersonDetailResponseDto(courseDetailData.getTeacher());
//        courseDetailResponseDto.setTeacher(teacher);

        CourseDetailResponseDto courseDetailResponseDto = new CourseDetailResponseDto(courseDetailData);
        return courseDetailResponseDto;
    }



}
