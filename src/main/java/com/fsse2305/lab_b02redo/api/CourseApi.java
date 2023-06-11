package com.fsse2305.lab_b02redo.api;

import com.fsse2305.lab_b02redo.data.CourseDetailData;
import com.fsse2305.lab_b02redo.data.CreateCourseData;
import com.fsse2305.lab_b02redo.data.UpdateCourseData;
import com.fsse2305.lab_b02redo.data.UpdatePersonData;
import com.fsse2305.lab_b02redo.data.dto.CourseDetailResponseDto;
import com.fsse2305.lab_b02redo.data.dto.CreateCourseRequestDto;
import com.fsse2305.lab_b02redo.data.dto.PersonDetailResponseDto;
import com.fsse2305.lab_b02redo.data.dto.UpdateCourseRequestDto;
import com.fsse2305.lab_b02redo.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/course")
    public List<CourseDetailResponseDto> getAllCourseData(){
        List<CourseDetailData> courseDetailDataList = courseService.getAllCourseDetails();
        List<CourseDetailResponseDto> courseDetailResponseDtoList = new ArrayList<>();
        for(CourseDetailData courseDetailData:courseDetailDataList){
            CourseDetailResponseDto courseDetailResponseDto = new CourseDetailResponseDto(courseDetailData);
            courseDetailResponseDtoList.add(courseDetailResponseDto);
        }
        return  courseDetailResponseDtoList;
    }


    @PutMapping("/course")
    public CourseDetailResponseDto updateCourseData(@RequestBody UpdateCourseRequestDto updateCourseRequestDto){
        UpdateCourseData updateCourseData = new UpdateCourseData(updateCourseRequestDto);

        CourseDetailData courseDetailData = courseService.updateCourseData(updateCourseData);
        CourseDetailResponseDto courseDetailResponseDto = new CourseDetailResponseDto(courseDetailData);
        return courseDetailResponseDto;
    }

    @DeleteMapping("/course/{course_id}")
    public CourseDetailResponseDto deleteCourse(@PathVariable("course_id")String courseId){
        CourseDetailData courseDetailData = courseService.deleteCourse(courseId);
        CourseDetailResponseDto courseDetailResponseDto = new CourseDetailResponseDto(courseDetailData);
        return courseDetailResponseDto;

    }


    @PatchMapping("/course/{course_id}/add-student/{person_hkid}")
    public CourseDetailResponseDto addStudent(@PathVariable ("course_id")String courseId, @PathVariable("person_hkid") String hkId){
        CourseDetailData courseDetailData = courseService.addStudent(courseId,hkId);

        CourseDetailResponseDto courseDetailResponseDto = new CourseDetailResponseDto(courseDetailData);
        return courseDetailResponseDto;
    }







}
