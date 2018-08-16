package com.example.tin.spacexrockets;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tin.spacexrockets.models.rocket.RocketResponse;
import com.example.tin.spacexrockets.models.rocketLaunch.RocketLaunchResponse;

import java.util.ArrayList;

import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    private DetailViewModel detailViewModel;

    private TextView descTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setupViews();

    }

    private void setupViews() {

        descTv = findViewById(R.id.tV_desc);

        Intent getIntent = getIntent();

        if (getIntent != null) {

            String rocketId = getIntent.getStringExtra("ID");
            descTv.setText(getIntent.getStringExtra("DESC"));

            bindOnViewModel(rocketId);

        } else {
            Toast.makeText(this, "Error loading data, please try again.", Toast.LENGTH_SHORT).show();
        }
    }

    private void bindOnViewModel(String rocketId) {

        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);

        detailViewModel.listenToDataChanges(rocketId).observe(this, new android.arch.lifecycle.Observer<ArrayList<RocketLaunchResponse>>() {
            @Override
            public void onChanged(@android.support.annotation.Nullable ArrayList<RocketLaunchResponse> response) {

                //mAdapter.addItems(rocketResponse);

//                Log.i(TAG, "response MissionName: " + response.get(0).getMissionName());
//                Log.i(TAG, "response Rocket Id: " + response.get(0).getRocket().getRocketId());


            }
        });

    }
}
