package org.cmpd.edu.core.repository.mongo;

import org.cmpd.edu.model.AssessmentAction;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ovoievodin on 28.12.2016.
 */
public interface AssessmentActionMongoRepository extends MongoRepository<AssessmentAction, String> {
}
