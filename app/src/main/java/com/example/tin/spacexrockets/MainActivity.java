package com.example.tin.spacexrockets;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.tin.spacexrockets.models.RocketResponse;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindOnViewModel();

    }

    private void bindOnViewModel() {

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.listenToDataChanges().observe(this, new Observer<List<RocketResponse>>() {
            @Override
            public void onChanged(@Nullable List<RocketResponse> rockets) {

                Log.d("MainActivity", "Rockets: " + rockets);
                //mAdapter.addItems(dataModels);

                String rocketName = rockets.get(0).getName();

                Log.d("MainActivity", "First Rocket Name: " + rocketName);

            }
        });

    }

}
