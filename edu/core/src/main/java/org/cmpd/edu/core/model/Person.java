package org.cmpd.edu.core.model;

import org.springframework.data.annotation.Id;

/**
 * Created by ovoievodin on 28.12.2016.
 */
public class Person {
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;

    public String getId() {
        return id;
    }

    @Id
    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
