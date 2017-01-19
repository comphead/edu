package org.cmpd.edu.assessmentbookapp.integration;

import java.lang.reflect.ParameterizedType;

import retrofit2.Retrofit;

/**
 * Created by ovoievodin on 19.01.2017.
 */

public class GenericRetrofitService<T> {
    private Retrofit client;

    public GenericRetrofitService(Retrofit client) {
        this.client = client;
    }

    public T getInstance() {
        return client.create((Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
}
