package com.example.tin.spacexrockets.utils;

import com.example.tin.spacexrockets.models.rocket.RocketResponse;

import java.util.ArrayList;


public class FilterRocketResponse {

    public static ArrayList<RocketResponse> filterRocketResponse(ArrayList<RocketResponse> rocketResponse) {

        ArrayList<RocketResponse> mFilteredRocketResponse = new ArrayList<>();

        for (int i = 0; i < rocketResponse.size(); i++) {

            if (rocketResponse.get(i).isActive()) {

                mFilteredRocketResponse.add(rocketResponse.get(i));
            }
        }

        return mFilteredRocketResponse;
    }
}
