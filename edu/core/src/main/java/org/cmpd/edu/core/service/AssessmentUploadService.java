package org.cmpd.edu.core.service;

import org.cmpd.edu.core.model.AssessmentAction;

import java.util.List;

/**
 * Created by ovoievodin on 28.12.2016.
 */
public interface AssessmentUploadService {
    void upload(List<AssessmentAction> actions);

    List<AssessmentAction> getAllActions();
}
