package com.fsse2305.lab_b02redo.data;

import com.fsse2305.lab_b02redo.data.entity.PersonEntity;

public class DeletedPersonData {
    private String firstName;
    private String lastName;
    private String hkid;

    public DeletedPersonData(PersonEntity personEntity){
        this.firstName = personEntity.getFirstName();
        this.lastName = personEntity.getLastName();
        this.hkid = personEntity.getHkid();
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
