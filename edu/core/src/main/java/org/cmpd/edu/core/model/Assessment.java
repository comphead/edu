package org.cmpd.edu.core.model;

/**
 * Created by ovoievodin on 27.12.2016.
 */
public class Assessment {
    private String base;
    private String comments;
    private AssessmentType type;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public AssessmentType getType() {
        return type;
    }

    public void setType(AssessmentType type) {
        this.type = type;
    }

    public enum AssessmentType {
        WORK
    }
}
