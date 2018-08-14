package com.example.tin.spacexrockets;


import android.app.Application;

import com.example.tin.spacexrockets.dagger.AndroidComponent;
import com.example.tin.spacexrockets.dagger.ApiModule;
import com.example.tin.spacexrockets.dagger.DaggerAndroidComponent;
import com.example.tin.spacexrockets.utils.Const;

public class AppClass extends Application {

    private AndroidComponent androidComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        daggerInit();

        androidComponent.inject(this);
    }

    private void daggerInit() {

        androidComponent = DaggerAndroidComponent.builder()
                .apiModule(new ApiModule(Const.BASE_URL))
                .build();
    }

    public AndroidComponent getAndroidComponent() {
        return androidComponent;
    }

}
