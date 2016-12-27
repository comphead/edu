package org.cmpd.edu.ws;

import org.cmpd.edu.core.model.EducationEntity;
import org.cmpd.edu.core.service.EducationEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ovoievodin on 26.12.2016.
 */
@RestController
public class DataUploadResource {

    @Autowired
    private EducationEntityService educationEntityService;

    @RequestMapping("/test")
    public List<EducationEntity> upload() {
        return educationEntityService.getAll();
    }
}
