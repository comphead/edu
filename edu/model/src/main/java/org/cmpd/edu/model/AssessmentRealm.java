package org.cmpd.edu.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ovoievodin on 27.12.2016.
 */
@Document(collection = "Realm")
public class AssessmentRealm {
    private String name;
    private String id;
    private AssessmentRealmType type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    @Id
    public void setId(String id) {
        this.id = id;
    }

    public AssessmentRealmType getType() {
        return type;
    }

    public void setType(AssessmentRealmType type) {
        this.type = type;
    }

    public enum AssessmentRealmType {
        EDU
    }
}
