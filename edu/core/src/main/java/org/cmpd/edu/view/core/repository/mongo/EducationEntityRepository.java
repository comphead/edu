package org.cmpd.edu.view.core.repository.mongo;

import org.cmpd.edu.core.model.EducationEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by ovoievodin on 27.12.2016.
 */
public interface EducationEntityRepository extends MongoRepository<EducationEntity, String> {
}
