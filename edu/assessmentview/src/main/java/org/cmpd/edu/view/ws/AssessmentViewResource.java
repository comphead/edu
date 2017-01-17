package org.cmpd.edu.view.ws;

import org.cmpd.edu.core.service.AssessmentViewService;
import org.cmpd.edu.model.AssessmentAction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by ovoievodin on 26.12.2016.
 */
@RestController
public class AssessmentViewResource {

    @Autowired
    private AssessmentViewService assessmentViewService;

    @RequestMapping(value = "/actions", method = RequestMethod.GET)
    public List<AssessmentAction> getAssessmentActions() {
        return assessmentViewService.getAllActions();
    }
}
