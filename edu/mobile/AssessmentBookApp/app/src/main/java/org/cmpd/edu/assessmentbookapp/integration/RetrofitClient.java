package org.cmpd.edu.assessmentbookapp.integration;

import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by ovoievodin on 19.01.2017.
 */

public class RetrofitClient {
    public Retrofit getInstance(String serverName) {
        return new Retrofit.Builder()
                .baseUrl(serverName)
                .addConverterFactory(JacksonConverterFactory.create())
                .build();
    }
}
