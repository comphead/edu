package org.cmpd.edu.core.model;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ovoievodin on 27.12.2016.
 */
@Document(collection = "Subject")
public class AssessmentSubject extends Person {

    private String extra1;
    private String extra2;
    private String extra3;

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
