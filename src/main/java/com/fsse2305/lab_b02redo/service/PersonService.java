package com.fsse2305.lab_b02redo.service;

import com.fsse2305.lab_b02redo.Exception.CreatePeopleException;
import com.fsse2305.lab_b02redo.Exception.NotFoundPeopleException;
import com.fsse2305.lab_b02redo.data.*;
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

    @Override
    public List<GotAllPersonData> gotAllPerson(){
        List<GotAllPersonData> gotAllPersonDataList = new ArrayList<>();
        for(PersonEntity personEntity: personEntityList){
            GotAllPersonData gotAllPersonData = new GotAllPersonData(personEntity);
            gotAllPersonDataList.add(gotAllPersonData);
        }

        return gotAllPersonDataList;

    }

    @Override
    public UpdatedPersonData updatePerson(UpdatePersonData updatePerson){

        for(PersonEntity personEntity:personEntityList){
            if(!personEntity.getHkid().equals(updatePerson.getHkid())){
                continue;
            }
            personEntity.setFirstName(updatePerson.getFirstName());
            personEntity.setLastName(updatePerson.getLastName());
            personEntity.setHkid(updatePerson.getHkid());

            UpdatedPersonData updatedPersonData = new UpdatedPersonData(personEntity);
            return updatedPersonData;
        }
        throw new NotFoundPeopleException();
    }

    public DeletedPersonData deletedPersonData(String hkid){
        for(PersonEntity personEntity: personEntityList){
            if(!personEntity.getHkid().equals(hkid)){
                continue;
            }
            personEntityList.remove(personEntity);
            DeletedPersonData deletedPersonData = new DeletedPersonData(personEntity);
            return deletedPersonData;
        }

        throw new NotFoundPeopleException();
    }

}
