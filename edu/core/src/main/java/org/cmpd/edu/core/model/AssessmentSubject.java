package org.cmpd.edu.core.model;

import org.springframework.data.annotation.Id;

/**
 * Created by ovoievodin on 27.12.2016.
 */
public class AssessmentSubject {
    private String id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String extra1;
    private String extra2;
    private String extra3;

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

    public String getExtra1() {
        return extra1;
    }

    public void setExtra1(String extra1) {
        this.extra1 = extra1;
    }

    public String getExtra2() {
        return extra2;
    }

    public void setExtra2(String extra2) {
        this.extra2 = extra2;
    }

    public String getExtra3() {
        return extra3;
    }

    public void setExtra3(String extra3) {
        this.extra3 = extra3;
    }
}
