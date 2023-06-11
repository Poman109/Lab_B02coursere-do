package com.fsse2305.lab_b02redo.data.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2305.lab_b02redo.data.PersonDetailDate;

public class PersonDetailResponseDto {
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("hkid_number")
    private String hkid;

    public PersonDetailResponseDto(PersonDetailDate personDetailDate){
        this.firstName = personDetailDate.getFirstName();
        this.lastName = personDetailDate.getLastName();
        this.hkid = personDetailDate.getHkid();
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
