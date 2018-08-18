package com.example.tin.spacexrockets;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.tin.spacexrockets.mvvm.MainActivity;

public class WelcomeActivity extends AppCompatActivity {

    SharedPreferences sharedPref;
    boolean firstTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        sharedPref = getSharedPreferences("welcome_Screen", MODE_PRIVATE);

        firstTime = sharedPref.getBoolean("firstTime", true);

        if (firstTime) {

            findViewById(R.id.btn_welcome).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    SharedPreferences.Editor editor = sharedPref.edit();
                    firstTime = false;
                    editor.putBoolean("firstTime", firstTime);
                    editor.apply();

                    Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
                    startActivity(intent);

                }
            });
        } else {

            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);

        }

    }
}
