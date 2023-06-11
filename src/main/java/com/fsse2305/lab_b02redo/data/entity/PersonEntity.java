package com.fsse2305.lab_b02redo.data.entity;

import com.fsse2305.lab_b02redo.data.CreatePersonData;

public class PersonEntity {
    private String firstName;
    private String lastName;
    private String hkid;

    public PersonEntity(CreatePersonData people){
        this.firstName = people.getFirstName();
        this.lastName = people.getLastName();
        this.hkid = people.getHkid();
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
