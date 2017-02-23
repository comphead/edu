package org.cmpd.edu.model;

import java.util.List;

/**
 * Created by ovoievodin on 23.02.2017.
 */
public class StaticDataContainer {
    private List<AssessmentInspector> inspectors;
    private List<AssessmentRealm> realms;
    private List<AssessmentSubject> subjects;

    public List<AssessmentInspector> getInspectors() {
        return inspectors;
    }

    public void setInspectors(List<AssessmentInspector> inspectors) {
        this.inspectors = inspectors;
    }

    public List<AssessmentRealm> getRealms() {
        return realms;
    }

    public void setRealms(List<AssessmentRealm> realms) {
        this.realms = realms;
    }

    public List<AssessmentSubject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<AssessmentSubject> subjects) {
        this.subjects = subjects;
    }
}
