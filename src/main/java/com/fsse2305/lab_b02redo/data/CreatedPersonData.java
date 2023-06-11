package com.fsse2305.lab_b02redo.data;

import com.fsse2305.lab_b02redo.data.entity.PersonEntity;

public class CreatedPersonData {
    private String firstName;
    private String lastName;
    private String hkid;

    public CreatedPersonData(PersonEntity person){
        this.firstName = person.getFirstName();
        this.lastName = person.getLastName();
        this.hkid = person.getHkid();
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
