package org.cmpd.edu.core.repository.mongo;

import org.cmpd.edu.core.model.AssessmentSubject;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ovoievodin on 30.12.2016.
 */
public interface AssessmentSubjectMongoRepository extends MongoRepository<AssessmentSubject, String> {
}
