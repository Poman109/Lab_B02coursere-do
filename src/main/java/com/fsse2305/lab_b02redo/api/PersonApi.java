package com.fsse2305.lab_b02redo.api;

import com.fsse2305.lab_b02redo.data.*;
import com.fsse2305.lab_b02redo.data.dto.*;
import com.fsse2305.lab_b02redo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonApi {

    private final PersonService personservice;

    @Autowired
    public PersonApi(PersonService personService){
        this.personservice = personService;
    }


    @PostMapping("/person")
    public CreatePersonResponseDto createPersonResponseDto(@RequestBody CreatePersonRequestDto createPersonRequestDto){
        CreatePersonData createPersonData = new CreatePersonData(createPersonRequestDto);
        CreatedPersonData createdPersonData = personservice.createPerson(createPersonData);
        CreatePersonResponseDto createPersonResponseDto = new CreatePersonResponseDto(createdPersonData);

        return createPersonResponseDto;
    }

    @GetMapping("person")
    public List<GetAllPersonResponseDto> getAllPerson(){
        List<GotAllPersonData> gotAllPersonDataList = personservice.gotAllPerson();
        List<GetAllPersonResponseDto> getAllPersonResponseArray = new ArrayList<>();

        for(GotAllPersonData gotAllPersonData: gotAllPersonDataList){
            GetAllPersonResponseDto getAllPersonResponseDto = new GetAllPersonResponseDto(gotAllPersonData);
            getAllPersonResponseArray.add(getAllPersonResponseDto);
        }

        return getAllPersonResponseArray;
    }

    @PutMapping("/person")
    public UpdatePersonDataResponseDto updatePerson(@RequestBody UpdatePersonDataRequestDto updatePersonDataRequestDto){
        UpdatePersonData updatePersonData = new UpdatePersonData(updatePersonDataRequestDto);
        UpdatedPersonData updatedPersonData = personservice.updatePerson(updatePersonData);

        UpdatePersonDataResponseDto updatePersonDataResponseDto = new UpdatePersonDataResponseDto(updatedPersonData);
        return updatePersonDataResponseDto;
    }


}
