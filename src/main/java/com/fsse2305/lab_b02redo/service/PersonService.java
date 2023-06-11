package com.fsse2305.lab_b02redo.service;

import com.fsse2305.lab_b02redo.Exception.CreatePeopleException;
import com.fsse2305.lab_b02redo.data.CreatePersonData;
import com.fsse2305.lab_b02redo.data.CreatedPersonData;
import com.fsse2305.lab_b02redo.data.GotAllPersonData;
import com.fsse2305.lab_b02redo.data.dto.CreatePersonRequestDto;
import com.fsse2305.lab_b02redo.data.dto.GetAllPersonResponseDto;
import com.fsse2305.lab_b02redo.data.entity.PersonEntity;
import com.fsse2305.lab_b02redo.service.impl.PersonServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonService implements PersonServiceImpl {
    private static List<PersonEntity> personEntityList = new ArrayList<>();

    @Override
    public CreatedPersonData createPerson(CreatePersonData createPersonData){

        if(createPersonData.getFirstName() == null||
        createPersonData.getLastName() == null||
        createPersonData.getHkid() == null){
            throw  new CreatePeopleException();
        }

        PersonEntity people = new PersonEntity(createPersonData);
        personEntityList.add(people);
        CreatedPersonData createdPersonData = new CreatedPersonData(people);
        return createdPersonData;

    }

    public List<GotAllPersonData> gotAllPerson(){
        List<GotAllPersonData> gotAllPersonDataList = new ArrayList<>();
        for(PersonEntity personEntity: personEntityList){
            GotAllPersonData gotAllPersonData = new GotAllPersonData(personEntity);
            gotAllPersonDataList.add(gotAllPersonData);
        }

        return gotAllPersonDataList;

    }

}
