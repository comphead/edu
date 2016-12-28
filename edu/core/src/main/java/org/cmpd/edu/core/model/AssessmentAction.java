package org.cmpd.edu.core.model;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by ovoievodin on 28.12.2016.
 */
@Document(collection = "action")
public class AssessmentAction {
    @DBRef
    private AssessmentInspector inspector;
    @DBRef
    private AssessmentSubject subject;
    private AssessmentProperties props;
    private Assessment assessment;
    @DBRef
    private AssessmentRealm realm;

    public AssessmentInspector getInspector() {
        return inspector;
    }

    public void setInspector(AssessmentInspector inspector) {
        this.inspector = inspector;
    }

    public AssessmentSubject getSubject() {
        return subject;
    }

    public void setSubject(AssessmentSubject subject) {
        this.subject = subject;
    }

    public AssessmentProperties getProps() {
        return props;
    }

    public void setProps(AssessmentProperties props) {
        this.props = props;
    }

    public Assessment getAssessment() {
        return assessment;
    }

    public void setAssessment(Assessment assessment) {
        this.assessment = assessment;
    }

    public AssessmentRealm getRealm() {
        return realm;
    }

    public void setRealm(AssessmentRealm realm) {
        this.realm = realm;
    }
}
