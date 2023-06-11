package com.fsse2305.lab_b02redo.data;

import com.fsse2305.lab_b02redo.data.dto.UpdatePersonDataRequestDto;

public class UpdatePersonData {
    private String firstName;
    private String lastName;
    private String hkid;

    public UpdatePersonData(UpdatePersonDataRequestDto updatePerson){
        this.firstName = updatePerson.getFirstName();
        this.lastName = updatePerson.getLastName();
        this.hkid = updatePerson.getHkid();

    }

    public String getLastName() {
        return lastName;
    }

    public String getHkid() {
        return hkid;
    }

    public String getFirstName() {
        return firstName;
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
