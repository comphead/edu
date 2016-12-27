package org.cmpd.edu.core.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ovoievodin on 27.12.2016.
 */
@Document(collection = "EducationEntity")
public class EducationEntity {
    private String name;
    private String id;

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
}
