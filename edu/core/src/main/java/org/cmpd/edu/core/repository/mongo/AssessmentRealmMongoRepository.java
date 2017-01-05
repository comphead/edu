package org.cmpd.edu.core.repository.mongo;

import org.cmpd.edu.model.AssessmentRealm;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ovoievodin on 30.12.2016.
 */
public interface AssessmentRealmMongoRepository extends MongoRepository<AssessmentRealm, String> {
}
