package com.fsse2305.lab_b02redo.service.impl;

import com.fsse2305.lab_b02redo.data.CreatePersonData;
import com.fsse2305.lab_b02redo.data.CreatedPersonData;

public interface PersonServiceImpl {

    CreatedPersonData createPerson(CreatePersonData createPersonData);
}
