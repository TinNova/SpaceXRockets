package com.example.tin.spacexrockets;

import android.util.Log;

import com.example.tin.spacexrockets.models.rocket.RocketResponse;
import com.example.tin.spacexrockets.models.rocketLaunch.RocketLaunchResponse;

import java.util.ArrayList;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiMethods {


    @GET("v2/rockets")
    Observable<ArrayList<RocketResponse>> getRockets();

    //    https://api.spacexdata.com/v2/launches?rocket_id=falcon1
    @GET("v2/launches?")
    Observable<ArrayList<RocketLaunchResponse>> getRocketLaunches(@Query("rocket_id") String rocketId);

}
