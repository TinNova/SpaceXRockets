package com.example.tin.spacexrockets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.tin.spacexrockets.models.RocketResponse;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainViewModel extends AndroidViewModel {

    private MutableLiveData<List<RocketResponse>> rockets;

    @Inject
    RestService restService;

    public MainViewModel(@NonNull Application application) {
        super(application);

        ((AppClass) application).getAndroidComponent().inject(this);

        Log.d("MainViewModel", "CoinViewModel: rest service " + restService);
    }

    public MutableLiveData<List<RocketResponse>> listenToDataChanges() {

        if (rockets == null) {

            rockets = new MutableLiveData<>();

            loadItems();
        }

        return rockets;
    }

    public void loadItems() {

        restService.getRockets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<RocketResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(List<RocketResponse> rocketResponse) {

                        //so here we tell our live data to NOTIFY ALL SUBSCRIBERS that data was changed
                        rockets.postValue(rocketResponse);
                        Log.d("MainViewModel", "RocketResponse: " + rocketResponse);

                    }

                    @Override
                    public void onError(Throwable e) {

                        Log.e("MainViewModel", "onError: error while load listings " + Log.getStackTraceString(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}