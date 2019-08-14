package com.hammadmukhtar.inlogic.main;

import com.hammadmukhtar.inlogic.api.models.Service;

import java.util.List;

public interface MainActivityMVP {

    interface View{
        void showResults(List<Service.Data> services);
        void showNoResults();
    }

    interface Presenter{
        void setView(MainActivityMVP.View view);

        void getServices();
        void saveServices(List<Service.Data> services);
    }

    interface Model{

        List<Service.Data> getServices();
        void saveServices(List<Service.Data> services);
    }
}
