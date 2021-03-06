package com.example.tin.spacexrockets.mvvm;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.tin.spacexrockets.R;
import com.example.tin.spacexrockets.mvvm.adapters.RocketAdapter;
import com.example.tin.spacexrockets.RocketPositionListener;
import com.example.tin.spacexrockets.StateOfLoading;
import com.example.tin.spacexrockets.models.rocket.RocketResponse;

import java.util.ArrayList;

import static com.example.tin.spacexrockets.StateOfLoading.stateCodes.LOADING;
import static com.example.tin.spacexrockets.StateOfLoading.stateCodes.LOADING_COMPLETE;
import static com.example.tin.spacexrockets.StateOfLoading.stateCodes.LOADING_ERROR;

public class MainActivity extends AppCompatActivity implements RocketPositionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private RocketAdapter mAdapter;
    private RecyclerView mRecyclerView;
    private ProgressBar mProgressBar;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupViews();

        bindOnViewModel();
    }

    private void setupViews() {

        /* Setting up the RecyclerView and Adapter*/
        mRecyclerView = findViewById(R.id.rV_main);
        mRecyclerView.setHasFixedSize(true);
        LinearLayoutManager mLinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mAdapter = new RocketAdapter(getApplicationContext(), this);
        mRecyclerView.setAdapter(mAdapter);

        mProgressBar = findViewById(R.id.pB_main);

        pullToRefresh();

    }

    private void bindOnViewModel() {

        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);

        mainViewModel.listenToStatesChanges().observe(this, new Observer<StateOfLoading.stateCodes>() {
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

        mainViewModel.listenToDataChanges().observe(this, new Observer<ArrayList<RocketResponse>>() {
            @Override
            public void onChanged(@Nullable ArrayList<RocketResponse> rocketResponse) {

                mAdapter.addItems(rocketResponse);

                hideProgressBar();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/menu_catalog.xml file.
        // This adds menu items to the app bar.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /**
     * Dropdown list of options when Menu button has been clicked
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        boolean FILTER_ACTIVE = false;
        if (item.getItemId() == R.id.filter_by_active) {

            FILTER_ACTIVE = true;


        } else if (item.getItemId() == R.id.filter_by_all) {

            FILTER_ACTIVE = false;

        }

        mainViewModel.listenToFilterChanges(FILTER_ACTIVE).observe(this, new Observer<ArrayList<RocketResponse>>() {
            @Override
            public void onChanged(@Nullable ArrayList<RocketResponse> rocketResponse) {

                mAdapter.addItems(rocketResponse);

            }
        });
        return super.onOptionsItemSelected(item);


    }

    private void pullToRefresh() {

        final SwipeRefreshLayout pullToRefresh = findViewById(R.id.sRL_main);

        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mainViewModel.loadItems();
                pullToRefresh.setRefreshing(false);
            }
        });
    }


    @Override
    public void rocketItemClick(RocketResponse rocketResponse) {

        Toast.makeText(this, "Name: " + rocketResponse.getName(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("ID", rocketResponse.getId());
        intent.putExtra("DESC", rocketResponse.getDescription());
        startActivity(intent);

    }

    public void hideProgressBar() {

        mProgressBar.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    public void showProgressBar() {

        mProgressBar.setVisibility(View.VISIBLE);
        mRecyclerView.setVisibility(View.GONE);
    }
}
