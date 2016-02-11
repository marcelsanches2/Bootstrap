package com.bootstrap.interactor;

import com.google.gson.Gson;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

/**
 * Created by msanches on 03/08/15.
 */
public abstract class BaseInteractor {

    public Service service;
    private RestAdapter restAdapter;

    public BaseInteractor() {
        setupBiometricService();
    }

    public void setupBiometricService() {
        restAdapter = getBaseRestAdapter().setEndpoint(getBaseUrl()).build();
        service = restAdapter.create(Service.class);
    }


    private RestAdapter.Builder getBaseRestAdapter() {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(new Gson()));
    }

    public abstract String getBaseUrl();

}
