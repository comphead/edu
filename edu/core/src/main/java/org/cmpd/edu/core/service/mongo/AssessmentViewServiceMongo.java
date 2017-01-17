package org.cmpd.edu.core.service.mongo;

import org.cmpd.edu.core.repository.mongo.AssessmentActionMongoRepository;
import org.cmpd.edu.core.service.AssessmentViewService;
import org.cmpd.edu.model.AssessmentAction;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by ovoievodin on 17.01.2017.
 */
public class AssessmentViewServiceMongo implements AssessmentViewService {
    @Autowired
    private AssessmentActionMongoRepository assessmentMongoRepository;

    @Override
    public List<AssessmentAction> getAllActions() {
        return assessmentMongoRepository.findAll();
    }
}
