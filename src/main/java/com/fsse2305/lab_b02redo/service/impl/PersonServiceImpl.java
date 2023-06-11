package com.fsse2305.lab_b02redo.service.impl;

import com.fsse2305.lab_b02redo.data.*;

import java.util.List;

public interface PersonServiceImpl {

    CreatedPersonData createPerson(CreatePersonData createPersonData);

    List<GotAllPersonData> gotAllPerson();

    UpdatedPersonData updatePerson(UpdatePersonData updatePerson);
}
