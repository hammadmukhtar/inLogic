package com.hammadmukhtar.inlogic.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.TextView;

import com.hammadmukhtar.inlogic.app.App;
import com.hammadmukhtar.inlogic.BaseActivity;
import com.hammadmukhtar.inlogic.R;
import com.hammadmukhtar.inlogic.api.ServicesAPI;
import com.hammadmukhtar.inlogic.api.models.Service;
import com.hammadmukhtar.inlogic.main.adapters.FragmentAdapter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends BaseActivity implements View.OnClickListener, MainActivityMVP.View, ServicesFragment.OnListFragmentInteractionListener {

    @Inject
    ServicesAPI servicesAPI;

    @Inject
    MainActivityMVP.Presenter presenter;

    ViewPager viewPager;
    FragmentAdapter pagerAdapter;
    TextView tvListView, tvGridView;

    final List<Fragment> fragList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Defining injection here so dagger component interface can be used */
        ((App)getApplication()).getComponent().inject(this);

        /* API call to get services */
        Call<Service> call = servicesAPI.getServices();
        showWaitDialog();
        call.enqueue(new Callback<Service>() {
            @Override
            public void onResponse(Call<Service> call, Response<Service> response) {
                hideWaitDialog();
                List<Service.Data> servicesList = response.body().getData();
                presenter.saveServices(servicesList);
            }

            @Override
            public void onFailure(Call<Service> call, Throwable t) {
                hideWaitDialog();
                presenter.getServices();
            }
        });

        /*Initializing views */
        viewPager = findViewById(R.id.viewPager);
        tvListView = findViewById(R.id.tvListView);
        tvListView.setOnClickListener(this);
        tvGridView = findViewById(R.id.tvGridView);
        tvGridView.setOnClickListener(this);

        FragmentManager fm = getSupportFragmentManager();
        pagerAdapter = new FragmentAdapter(fm, fragList);
        viewPager.setAdapter(pagerAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
    }


    @Override
    public void onListFragmentInteraction(Service.Data item) {

    }

    /* Update the Listing*/
    @Override
    public void showResults(List<Service.Data> services) {
        fragList.clear();
        fragList.add(ServicesFragment.newInstance(1, services));
        fragList.add(ServicesFragment.newInstance(2, services));
        pagerAdapter.notifyDataSetChanged();

        findViewById(R.id.noServiceFound).setVisibility(View.GONE);
    }

    @Override
    public void showNoResults() {
        findViewById(R.id.noServiceFound).setVisibility(View.VISIBLE);
    }

    @Override
    public void onClick(View view) {
        /*Toggle implementation on clicks*/
        switch (view.getId()){
            case R.id.tvListView:
                tvListView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvGridView.setBackgroundColor(getResources().getColor(android.R.color.white));
                tvListView.setTextColor(getResources().getColor(android.R.color.white));
                tvGridView.setTextColor(getResources().getColor(android.R.color.black));
                viewPager.setCurrentItem(0, true);
                break;

            case R.id.tvGridView:
                tvGridView.setBackgroundColor(getResources().getColor(R.color.colorAccent));
                tvListView.setBackgroundColor(getResources().getColor(android.R.color.white));
                tvGridView.setTextColor(getResources().getColor(android.R.color.white));
                tvListView.setTextColor(getResources().getColor(android.R.color.black));
                viewPager.setCurrentItem(1, true);
                break;
        }
    }
}
