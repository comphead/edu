package org.cmpd.edu.core.service.mongo;

import org.cmpd.edu.core.service.StaticDataViewService;
import org.cmpd.edu.model.StaticDataContainer;

/**
 * Created by ovoievodin on 23.02.2017.
 */
public class StaticDataViewServiceMongo extends AbstractStaticDataServiceMongo implements StaticDataViewService {
    @Override
    public StaticDataContainer getAllEntries() {
        StaticDataContainer dataContainer = new StaticDataContainer();
        dataContainer.setInspectors(assessmentInspectorMongoRepository.findAll());
        dataContainer.setRealms(assessmentRealmMongoRepository.findAll());
        dataContainer.setSubjects(assessmentSubjectMongoRepository.findAll());

        return dataContainer;
    }
}
