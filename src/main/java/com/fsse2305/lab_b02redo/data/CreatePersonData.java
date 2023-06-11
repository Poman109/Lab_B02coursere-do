package com.fsse2305.lab_b02redo.data;

import com.fsse2305.lab_b02redo.data.dto.CreatePersonRequestDto;

public class CreatePersonData {
    private String firstName;
    private String lastName;
    private String hkid;

    public CreatePersonData(CreatePersonRequestDto createPersonRequest){
        this.firstName = createPersonRequest.getFirstName();
        this.lastName = createPersonRequest.getLastName();
        this.hkid = createPersonRequest.getHkid();
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
