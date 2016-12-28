package org.cmpd.edu.upload.ws;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.cmpd.edu.core.model.*;
import org.cmpd.edu.upload.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ovoievodin on 28.12.2016.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class DataUploadResourceIntTest {
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;

    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void testUpload() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        HttpEntity<String> postBody = new HttpEntity<>(mapper.writeValueAsString(createAssesmentActionsList()));
        template.postForLocation(base + "/uploadActions", postBody);
    }

    private List<AssessmentAction> createAssesmentActionsList() {
        List<AssessmentAction> result = new ArrayList<>();
        AssessmentAction action1 = new AssessmentAction();

        Assessment assessment = new Assessment();
        assessment.setType(Assessment.AssessmentType.WORK);
        assessment.setBase("Good");
        assessment.setComments("Need to be faster");
        action1.setAssessment(assessment);

        AssessmentInspector inspector = new AssessmentInspector();
        inspector.setFirstName("Name1");
        inspector.setSecondName("Name2");
        inspector.setLastName("Name3");
        action1.setInspector(inspector);

        AssessmentRealm realm = new AssessmentRealm();
        realm.setName("s303");
        realm.setType(AssessmentRealm.AssessmentRealmType.EDU);
        action1.setRealm(realm);

        AssessmentSubject subject = new AssessmentSubject();
        subject.setFirstName("NameS1");
        subject.setSecondName("NameS2");
        subject.setLastName("NameS3");
        action1.setSubject(subject);

        AssessmentAction action2 = new AssessmentAction();

        Assessment assessment2 = new Assessment();
        assessment2.setType(Assessment.AssessmentType.WORK);
        assessment2.setBase("Bad");
        assessment2.setComments("Need to be super faster");
        action2.setAssessment(assessment2);

        AssessmentInspector inspector2 = new AssessmentInspector();
        inspector2.setFirstName("Name1");
        inspector2.setSecondName("Name2");
        inspector2.setLastName("Name3");
        action2.setInspector(inspector2);

        AssessmentRealm realm2 = new AssessmentRealm();
        realm2.setName("s303");
        realm2.setType(AssessmentRealm.AssessmentRealmType.EDU);
        action2.setRealm(realm2);

        AssessmentSubject subject2 = new AssessmentSubject();
        subject2.setFirstName("NameS1");
        subject2.setSecondName("NameS2");
        subject2.setLastName("NameS3");
        action2.setSubject(subject2);

        result.add(action1);
        result.add(action2);

        return result;
    }
}