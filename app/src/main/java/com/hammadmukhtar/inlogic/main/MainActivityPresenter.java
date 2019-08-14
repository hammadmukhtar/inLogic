package com.hammadmukhtar.inlogic.main;

import com.hammadmukhtar.inlogic.api.models.Service;

import java.util.List;

public class MainActivityPresenter implements MainActivityMVP.Presenter{

    private MainActivityMVP.View view;
    private MainActivityMVP.Model model;

    public MainActivityPresenter(MainActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(MainActivityMVP.View view) {
        this.view = view;
    }

    @Override
    public void saveServices(List<Service.Data> services) {
        model.saveServices(services);
        getServices();
    }

    @Override
    public void getServices() {
        List<Service.Data> services = model.getServices();

        if(services != null && services.size() > 0){
            if(view != null){
                view.showResults(services);
            }
        } else {
            if(view != null){
                view.showNoResults();
            }
        }
    }
}
