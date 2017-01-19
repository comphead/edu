package org.cmpd.edu.assessmentbookapp.integration;

import org.cmpd.edu.model.AssessmentAction;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ovoievodin on 17.01.2017.
 */

public interface AssessmentAPI {
    @GET("/v/actions")
    Call<List<AssessmentAction>> getAssessmentActions();
}
