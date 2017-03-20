package org.cmpd.edu.model;

/**
 * Created by ovoievodin on 27.12.2016.
 */
public class Assessment {
    private String code;
    private String comments;
    private AssessmentType type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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
        WORK,
        EXAM,
        BEHAVIOR,
        HOMEWORK,
        CLASSWORK
    }
}
