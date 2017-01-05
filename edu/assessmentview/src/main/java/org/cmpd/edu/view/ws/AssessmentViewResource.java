package org.cmpd.edu.view.ws;

import org.cmpd.edu.core.service.AssessmentUploadService;
import org.cmpd.edu.model.AssessmentAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ovoievodin on 26.12.2016.
 */
@RestController
public class AssessmentViewResource {

    @Autowired
    private AssessmentUploadService assessmentUploadService;

    @RequestMapping("/actions")
    public List<AssessmentAction> getAssessmentActions() {
        return assessmentUploadService.getAllActions();
    }
}
