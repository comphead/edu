package org.cmpd.edu.assessmentbookapp.integration;

import org.cmpd.edu.model.AssessmentAction;
import org.cmpd.edu.model.StaticDataContainer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by ovoievodin on 23.02.2017.
 */

public interface StaticDataAPI {
    @GET("/v/static")
    Call<StaticDataContainer> getStaticDataContainer();
}
