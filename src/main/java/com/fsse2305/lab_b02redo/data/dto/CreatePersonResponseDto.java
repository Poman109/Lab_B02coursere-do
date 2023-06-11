package com.fsse2305.lab_b02redo.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.lab_b02redo.data.CreatedPersonData;

public class CreatePersonResponseDto {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("hkid_number")
    private String hkid;

    public CreatePersonResponseDto(CreatedPersonData createdPersonData){
        this.firstName = createdPersonData.getFirstName();
        this.lastName = createdPersonData.getLastName();
        this.hkid = createdPersonData.getHkid();

    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getHkid() {
        return hkid;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHkid(String hkid) {
        this.hkid = hkid;
    }
}
