package org.cmpd.edu.core.service.mongo;

import org.cmpd.edu.core.repository.mongo.AssessmentActionMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ovoievodin on 23.02.2017.
 */
public class AbstractAssessmentServiceMongo {
    @Autowired
    protected AssessmentActionMongoRepository assessmentMongoRepository;
}
