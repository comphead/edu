package org.cmpd.edu.core.service.mongo;

import org.cmpd.edu.core.model.EducationEntity;
import org.cmpd.edu.core.repository.mongo.EducationEntityRepository;
import org.cmpd.edu.core.service.EducationEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ovoievodin on 27.12.2016.
 */
@Service
public class EducationEntityServiceMongo implements EducationEntityService{

    @Autowired
    private EducationEntityRepository educationEntityRepository;

    @Override
    public List<EducationEntity> getAll() {
        return educationEntityRepository.findAll();
    }
}
