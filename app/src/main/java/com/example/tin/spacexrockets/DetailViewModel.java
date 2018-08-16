package com.example.tin.spacexrockets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.tin.spacexrockets.models.rocketLaunch.RocketLaunchResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class DetailViewModel extends AndroidViewModel {

    private static final String TAG = DetailViewModel.class.getSimpleName();

    private MutableLiveData<ArrayList<RocketLaunchResponse>> rocketLaunches;

    @Inject
    RestService restService;

    public DetailViewModel(@NonNull Application application) {
        super(application);

        ((AppClass) application).getAndroidComponent().inject(this);

    }

    public MutableLiveData<ArrayList<RocketLaunchResponse>> listenToDataChanges(String rocketId) {

        if (rocketLaunches == null) {

            rocketLaunches = new MutableLiveData<>();

            loadItems(rocketId);
        }

        return rocketLaunches;
    }

    public void loadItems(String rocketId) {

        restService.getRocketLaunches(rocketId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<RocketLaunchResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArrayList<RocketLaunchResponse> rocketLaunchResponse) {

                        //so here we tell our live data to NOTIFY ALL SUBSCRIBERS that data was changed
                        rocketLaunches.postValue(rocketLaunchResponse);
                        Log.d("DetailViewModel", "RocketLaunchResponse: " + rocketLaunchResponse);

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("DetailViewModel", "onError: error while load listings " + Log.getStackTraceString(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
