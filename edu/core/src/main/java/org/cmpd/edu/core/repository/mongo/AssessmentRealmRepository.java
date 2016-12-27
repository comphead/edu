package org.cmpd.edu.core.repository.mongo;

import org.cmpd.edu.core.model.AssessmentRealm;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ovoievodin on 27.12.2016.
 */
public interface AssessmentRealmRepository extends MongoRepository<AssessmentRealm, String> {
}
