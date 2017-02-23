package org.cmpd.edu.core.service.mongo;

import org.cmpd.edu.core.service.StaticDataUploadService;
import org.cmpd.edu.model.StaticDataContainer;

/**
 * Created by ovoievodin on 23.02.2017.
 */
public class StaticDataUploadServiceMongo extends AbstractStaticDataServiceMongo implements StaticDataUploadService {
    @Override
    public void upload(StaticDataContainer data) {
        assessmentInspectorMongoRepository.insert(data.getInspectors());
        assessmentRealmMongoRepository.insert(data.getRealms());
        assessmentSubjectMongoRepository.insert(data.getSubjects());
    }
}
