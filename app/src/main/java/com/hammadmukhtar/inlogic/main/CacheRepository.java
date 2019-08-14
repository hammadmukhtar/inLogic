package com.hammadmukhtar.inlogic.main;

import com.hammadmukhtar.inlogic.api.models.Service;
import com.hammadmukhtar.inlogic.preferences.CONSTANTS;
import com.hammadmukhtar.inlogic.preferences.Preferences;

import java.util.ArrayList;
import java.util.List;

public class CacheRepository implements MainRepository {

    private List<Service.Data> services;

    @Override
    public List<Service.Data> getServices() {
        return Preferences.getList(CONSTANTS.SERVICES_LIST);
    }

    @Override
    public void saveServices(List<Service.Data> services) {
        if(services == null){
            services = new ArrayList<>();
        }
        this.services = services;
        Preferences.update(CONSTANTS.SERVICES_LIST, services);
    }
}
