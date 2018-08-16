package com.example.tin.spacexrockets;

import android.util.Log;

import com.example.tin.spacexrockets.models.rocket.RocketResponse;
import com.example.tin.spacexrockets.models.rocketLaunch.RocketLaunchResponse;

import java.util.ArrayList;

import io.reactivex.Observable;


public class RestService {

    private static final String TAG = RestService.class.getSimpleName();

    private ApiMethods apiMethods;

    public RestService(ApiMethods apiMethods) {

        this.apiMethods = apiMethods;
    }

    public Observable<ArrayList<RocketResponse>> getRockets() {
        /* Here we receive the Response, (which is already parsed when it arrives here) */
        return apiMethods.getRockets();
    }

    public Observable<ArrayList<RocketLaunchResponse>> getRocketLaunches(String rocketId) {
        /* Here we receive the Response, (which is already parsed when it arrives here) */
        return apiMethods.getRocketLaunches(rocketId);
    }
}
