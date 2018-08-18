package com.example.tin.spacexrockets.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tin.spacexrockets.R;
import com.example.tin.spacexrockets.mvvm.adapters.RocketLaunchAdapter;
import com.example.tin.spacexrockets.StateOfLoading;
import com.example.tin.spacexrockets.models.rocketLaunch.RocketLaunchResponse;

import java.util.ArrayList;

import io.reactivex.annotations.Nullable;

import static com.example.tin.spacexrockets.StateOfLoading.stateCodes.LOADING;
import static com.example.tin.spacexrockets.StateOfLoading.stateCodes.LOADING_COMPLETE;
import static com.example.tin.spacexrockets.StateOfLoading.stateCodes.LOADING_ERROR;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    private RocketLaunchAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private DetailViewModel detailViewModel;
    private ProgressBar mProgressBar;

    private TextView descTv;
    private TextView descTitleTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setupViews();

    }

    private void setupViews() {

        descTv = findViewById(R.id.tV_desc);

        Intent getIntent = getIntent();

        if (getIntent == null) {

            Toast.makeText(this, "Error loading data, please try again.", Toast.LENGTH_SHORT).show();

        } else {

            descTitleTv = findViewById(R.id.tV_descTitle);
            mProgressBar = findViewById(R.id.pB_detail);

            /* Setting up the RecyclerView and Adapter*/
            mRecyclerView = findViewById(R.id.rV_detail);
            mRecyclerView.setHasFixedSize(true);
            LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLinearLayoutManager);

            mAdapter = new RocketLaunchAdapter(getApplicationContext());
            mRecyclerView.setAdapter(mAdapter);

            String rocketId = getIntent.getStringExtra("ID");
            descTv.setText(getIntent.getStringExtra("DESC"));

            bindOnViewModel(rocketId);
        }
    }

    private void bindOnViewModel(String rocketId) {

        detailViewModel = ViewModelProviders.of(this).get(DetailViewModel.class);

        detailViewModel.listenToStatesChanges(rocketId).observe(this, new Observer<StateOfLoading.stateCodes>() {
            @Override
            public void onChanged(@Nullable StateOfLoading.stateCodes state) {

                if (state.code == LOADING) {

                    showProgressBar();

                } else if (state.code == LOADING_COMPLETE) {

                    hideProgressBar();

                } else if (state.code == LOADING_ERROR) {

                    hideProgressBar();
                    // or Toast or Alert Dialogue
                }
            }
        });


        detailViewModel.listenToDataChanges(rocketId).observe(this, new android.arch.lifecycle.Observer<ArrayList<RocketLaunchResponse>>() {
            @Override
            public void onChanged(@android.support.annotation.Nullable ArrayList<RocketLaunchResponse> response) {

                mAdapter.addItems(response);

                // Never triggered if Big Falcon Rocket is clicked on, check onNext in ViewModel for more info
                hideProgressBar();
            }
        });
    }


    //TODO: Hide progress bar when data has downloaded in onNext in ViewModel
    public void hideProgressBar() {

        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        descTitleTv.setVisibility(View.VISIBLE);
        descTv.setVisibility(View.VISIBLE);
    }

    public void showProgressBar() {

        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
        descTitleTv.setVisibility(View.GONE);
        descTv.setVisibility(View.GONE);
    }
}
