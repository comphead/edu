package org.cmpd.edu.upload.ws;

import org.cmpd.edu.core.service.AssessmentUploadService;
import org.cmpd.edu.core.service.StaticDataUploadService;
import org.cmpd.edu.model.AssessmentAction;
import org.cmpd.edu.model.StaticDataContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ovoievodin on 26.12.2016.
 */
@RestController
public class DataUploadResource {

    @Autowired
    private AssessmentUploadService assessmentUploadService;

    @Autowired
    private StaticDataUploadService staticDataUploadService;

    @RequestMapping(value = "/uploadActions", method = RequestMethod.POST)
    public void upload(@RequestBody  List<AssessmentAction> actions) {
        assessmentUploadService.upload(actions);
    }

    @RequestMapping(value = "/uploadStatic", method = RequestMethod.POST)
    public void uploadStatic(@RequestBody StaticDataContainer dataContainer) {
        staticDataUploadService.upload(dataContainer);
    }
}
