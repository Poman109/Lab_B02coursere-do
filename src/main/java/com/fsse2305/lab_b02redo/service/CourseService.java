package com.fsse2305.lab_b02redo.service;

import com.fsse2305.lab_b02redo.Exception.CannotUpdateClassException;
import com.fsse2305.lab_b02redo.Exception.ErrorDeleteCourseException;
import com.fsse2305.lab_b02redo.Exception.ErrorDeleteStudent;
import com.fsse2305.lab_b02redo.Exception.ErrorUpdateStudent;
import com.fsse2305.lab_b02redo.data.CourseDetailData;
import com.fsse2305.lab_b02redo.data.CreateCourseData;
import com.fsse2305.lab_b02redo.data.PersonDetailDate;
import com.fsse2305.lab_b02redo.data.UpdateCourseData;
import com.fsse2305.lab_b02redo.data.entity.CourseEntity;
import com.fsse2305.lab_b02redo.data.entity.PersonEntity;
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

    @Override
    public CourseDetailData createCourse(CreateCourseData createCourseData){
        CourseEntity courseEntity = new CourseEntity();
        courseEntity.setCourseId(createCourseData.getCourseId());
        courseEntity.setName(createCourseData.getName());
        courseEntity.setPrice(createCourseData.getPrice());
        courseEntity.setTeacher(personService.getPerson(createCourseData.getTeacherHkid()));
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


    @Override
    public List<CourseDetailData> getAllCourseDetails(){
        List<CourseDetailData> courseArray = new ArrayList<>();
        for(CourseEntity courseEntity: courseEntityArray){
             CourseDetailData courseDetailData = new CourseDetailData(courseEntity);
             courseArray.add(courseDetailData);
        }
        return courseArray;

    }

    @Override
    public CourseDetailData updateCourseData (UpdateCourseData updateCourseData){
        for(CourseEntity courseEntity: courseEntityArray){
            if(!courseEntity.getCourseId().equals(updateCourseData.getCourseId())){
                continue;
            }
            courseEntity.setName(updateCourseData.getName());
            courseEntity.setPrice(updateCourseData.getPrice());
            courseEntity.setTeacher(personService.getPerson(updateCourseData.getTeacherHkid()));

            CourseDetailData courseDetailData = new CourseDetailData(courseEntity);
            return courseDetailData;
        }
        throw new CannotUpdateClassException();
    }

    @Override
    public CourseDetailData deleteCourse(String courseId){
        for(CourseEntity courseEntity: courseEntityArray){
            if (!courseEntity.getCourseId().equals(courseId)){
                continue;
            }
            courseEntityArray.remove(courseEntity);
            CourseDetailData courseDetailData = new CourseDetailData(courseEntity);
            return courseDetailData;
        }

        throw new ErrorDeleteCourseException();

    }

    @Override
    public CourseDetailData addStudent(String courseId,String hkid){
        for(CourseEntity courseEntity:courseEntityArray){
            if(!courseEntity.getCourseId().equals(courseId)){
                continue;
            }

            if(personService.checkStudent(courseEntity,hkid)){

                    courseEntity.getStudents().add(personService.getPerson(hkid));
                    CourseDetailData courseDetailData = new CourseDetailData(courseEntity);
                    return courseDetailData;
            }
        }
        throw new ErrorUpdateStudent();
    }

    @Override
    public CourseDetailData deleteStudent(String courseId, String hkid){
        for(CourseEntity courseEntity: courseEntityArray){
            if (!(courseEntity.getCourseId().equals(courseId))){
                continue;
            }

            for(PersonEntity personEntity: courseEntity.getStudents()){
                if(!personEntity.getHkid().equals(hkid)){
                    continue;
                }
                courseEntity.getStudents().remove(personEntity);
                CourseDetailData courseDetailData = new CourseDetailData(courseEntity);
                return courseDetailData;
            }
        }

        throw new ErrorDeleteStudent();
    }





}
