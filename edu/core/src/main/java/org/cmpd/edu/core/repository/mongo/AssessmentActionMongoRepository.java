package org.cmpd.edu.core.repository.mongo;

import org.cmpd.edu.core.model.AssessmentAction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by ovoievodin on 28.12.2016.
 */
@Repository
public interface AssessmentActionMongoRepository extends MongoRepository<AssessmentAction, String> {
}
