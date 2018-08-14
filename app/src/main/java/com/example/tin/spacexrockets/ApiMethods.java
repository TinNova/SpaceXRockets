package com.example.tin.spacexrockets;

import com.example.tin.spacexrockets.models.RocketResponse;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;


public interface ApiMethods {

    @GET("v2/rockets")
    Observable<List<RocketResponse>> getRockets();
}
