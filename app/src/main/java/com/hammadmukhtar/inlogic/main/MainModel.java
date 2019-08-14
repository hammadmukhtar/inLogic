package com.hammadmukhtar.inlogic.main;

import com.hammadmukhtar.inlogic.api.models.Service;

import java.util.List;

public class MainModel implements MainActivityMVP.Model{

    private MainRepository repository;

    @Override
    public void saveServices(List<Service.Data> services) {
        repository.saveServices(services);
    }

    public MainModel(MainRepository respository) {
        this.repository = respository;
    }

    @Override
    public List<Service.Data> getServices() {
        return repository.getServices();
    }
}
