package org.cmpd.edu.core.service.mongo;

import org.cmpd.edu.core.model.AssessmentAction;
import org.cmpd.edu.core.repository.mongo.AssessmentActionMongoRepository;
import org.cmpd.edu.core.service.AssessmentUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ovoievodin on 28.12.2016.
 */
@Service
public class AssessmentUploadServiceMongo implements AssessmentUploadService{
    @Autowired
    private AssessmentActionMongoRepository assessmentMongoRepository;

    @Override
    public void upload(List<AssessmentAction> actions) {
        assessmentMongoRepository.insert(actions);
    }
}
