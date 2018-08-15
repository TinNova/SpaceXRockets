package com.example.tin.spacexrockets;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.tin.spacexrockets.models.RocketResponse;
import com.example.tin.spacexrockets.utils.Const;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RocketPositionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private MainViewModel mainViewModel;
    private RocketAdapter mAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        bindOnViewModel();

    }

    private void bindOnViewModel() {

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.listenToDataChanges().observe(this, new Observer<ArrayList<RocketResponse>>() {
            @Override
            public void onChanged(@Nullable ArrayList<RocketResponse> rocketResponse) {

                mAdapter.addItems(rocketResponse);

            }
        });
    }

    private void setupViews() {

        /* Setting up the RecyclerView and Adapter*/
        mRecyclerView = findViewById(R.id.rV_main);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mAdapter = new RocketAdapter(getApplicationContext(), this);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void rocketItemClick(RocketResponse rocketResponse) {

        Toast.makeText(this, "Name: " + rocketResponse.getName(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("ID", rocketResponse.getId());
        intent.putExtra("DESC", rocketResponse.getDescription());
        startActivity(intent);

    }
}
