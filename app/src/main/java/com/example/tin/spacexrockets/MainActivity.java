package com.example.tin.spacexrockets;

import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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

    }
}
