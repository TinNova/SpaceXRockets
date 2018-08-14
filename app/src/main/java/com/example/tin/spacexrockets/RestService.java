package com.example.tin.spacexrockets;

import com.example.tin.spacexrockets.models.RocketResponse;

import io.reactivex.Observable;


public class RestService {

    private ApiMethods apiMethods;

    public RestService(ApiMethods apiMethods) {

        this.apiMethods = apiMethods;
    }

    public Observable<RocketResponse> getRockets() {
        /* Here we receive the ListingResponse, (which is already parsed when it arrives here) */
        return apiMethods.getRockets();
    }
}
