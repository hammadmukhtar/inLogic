package com.hammadmukhtar.inlogic.api;

import com.hammadmukhtar.inlogic.api.models.Service;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServicesAPI {

    @GET("services")
    Call<Service> getServices();
}
