package org.cmpd.edu.core.service.mongo;

import org.cmpd.edu.core.repository.mongo.AssessmentInspectorMongoRepository;
import org.cmpd.edu.core.repository.mongo.AssessmentRealmMongoRepository;
import org.cmpd.edu.core.repository.mongo.AssessmentSubjectMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by ovoievodin on 23.02.2017.
 */
public class AbstractStaticDataServiceMongo {
    @Autowired
    protected AssessmentSubjectMongoRepository assessmentSubjectMongoRepository;

    @Autowired
    protected AssessmentInspectorMongoRepository assessmentInspectorMongoRepository;

    @Autowired
    protected AssessmentRealmMongoRepository assessmentRealmMongoRepository;
}
