package org.cmpd.edu.core.service.mongo;

import org.cmpd.edu.core.service.AssessmentViewService;
import org.cmpd.edu.model.AssessmentAction;

import java.util.List;

/**
 * Created by ovoievodin on 17.01.2017.
 */
public class AssessmentViewServiceMongo extends AbstractAssessmentServiceMongo implements AssessmentViewService {
    @Override
    public List<AssessmentAction> getAllEntries() {
        return assessmentMongoRepository.findAll();
    }
}
