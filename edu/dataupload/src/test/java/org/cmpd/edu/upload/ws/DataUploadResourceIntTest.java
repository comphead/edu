package org.cmpd.edu.upload.ws;

import org.cmpd.edu.core.model.*;
import org.cmpd.edu.upload.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

/**
 * Created by ovoievodin on 28.12.2016.
 */
/*
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
*/
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class DataUploadResourceIntTest {


    private URL base;

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

//    @Autowired
//    private TestRestTemplate template;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.asList(converters).stream()
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    @Before
    public void setUp() throws Exception {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
//        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    @Commit
    public void testUpload() throws Exception {
        mockMvc.perform(
                post("/uploadActions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json(createAssesmentActionsList())))
                .andExpect(status().isOk());

//        ObjectMapper mapper = new ObjectMapper();
//
//        HttpEntity<String> postBody = new HttpEntity<>(mapper.writeValueAsString(createAssesmentActionsList()));
//        template.postForObject(base + "uploadActions", postBody, String.class);
    }

    protected String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        this.mappingJackson2HttpMessageConverter.write(
                o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
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
        inspector.setId("XX123456");
        action1.setInspector(inspector);

        AssessmentRealm realm = new AssessmentRealm();
        realm.setName("s303");
        realm.setType(AssessmentRealm.AssessmentRealmType.EDU);
        realm.setId("s303_kiev");
        action1.setRealm(realm);

        AssessmentSubject subject = new AssessmentSubject();
        subject.setFirstName("NameS1");
        subject.setSecondName("NameS2");
        subject.setLastName("NameS3");
        subject.setId("XX654321");
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
        inspector2.setId("XX123456");
        action2.setInspector(inspector2);

        AssessmentRealm realm2 = new AssessmentRealm();
        realm2.setName("s303");
        realm2.setType(AssessmentRealm.AssessmentRealmType.EDU);
        realm2.setId("s303_kiev");
        action2.setRealm(realm2);

        AssessmentSubject subject2 = new AssessmentSubject();
        subject2.setFirstName("NameS1");
        subject2.setSecondName("NameS2");
        subject2.setLastName("NameS3");
        subject2.setId("XX654321");
        action2.setSubject(subject2);

        result.add(action1);
        result.add(action2);

        return result;
    }
}