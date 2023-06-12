package com.fsse2305.lab_b02redo.service.impl;

import com.fsse2305.lab_b02redo.data.*;
import com.fsse2305.lab_b02redo.data.entity.CourseEntity;
import com.fsse2305.lab_b02redo.data.entity.PersonEntity;

import java.util.List;

public interface PersonServiceImpl {

    CreatedPersonData createPerson(CreatePersonData createPersonData);

    List<GotAllPersonData> gotAllPerson();

    UpdatedPersonData updatePerson(UpdatePersonData updatePerson);

    DeletedPersonData deletedPersonData(String hkid);

    PersonEntity getPerson(String hkid);

    Boolean checkStudent(CourseEntity courseEntity, String hkid);
}
