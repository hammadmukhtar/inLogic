package com.hammadmukhtar.inlogic.main;

import com.hammadmukhtar.inlogic.api.models.Service;

import java.util.List;

public interface MainRepository {

    List<Service.Data> getServices();
    void saveServices(List<Service.Data> services);
}
