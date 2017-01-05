package org.cmpd.edu.core.repository.mongo;

import org.cmpd.edu.model.AssessmentInspector;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ovoievodin on 30.12.2016.
 */
public interface AssessmentInspectorMongoRepository extends MongoRepository<AssessmentInspector, String> {
}
