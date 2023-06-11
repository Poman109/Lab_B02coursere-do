package com.fsse2305.lab_b02redo.api;

import com.fsse2305.lab_b02redo.data.CreatePersonData;
import com.fsse2305.lab_b02redo.data.CreatedPersonData;
import com.fsse2305.lab_b02redo.data.dto.CreatePersonRequestDto;
import com.fsse2305.lab_b02redo.data.dto.CreatePersonResponseDto;
import com.fsse2305.lab_b02redo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
