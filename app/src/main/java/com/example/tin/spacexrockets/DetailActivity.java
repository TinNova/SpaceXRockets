package com.example.tin.spacexrockets;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tin.spacexrockets.models.RocketResponse;
import com.example.tin.spacexrockets.utils.Const;

import java.util.ArrayList;

import static com.example.tin.spacexrockets.utils.Const.ARG_ROCKET_BUNDLE;

public class DetailActivity extends AppCompatActivity {

    private static final String TAG = DetailActivity.class.getSimpleName();

    private TextView descTv;

    RocketResponse mRocketResponse;


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

            String id = getIntent.getStringExtra("ID");
            descTv.setText(getIntent.getStringExtra("DESC"));

        } else {
            Toast.makeText(this, "Error loading data, please try again.", Toast.LENGTH_SHORT).show();
        }
    }
}
