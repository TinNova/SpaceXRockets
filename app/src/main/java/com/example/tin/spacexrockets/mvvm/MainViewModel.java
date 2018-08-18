package com.example.tin.spacexrockets.mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.tin.spacexrockets.AppClass;
import com.example.tin.spacexrockets.utils.FilterRocketResponse;
import com.example.tin.spacexrockets.RestService;
import com.example.tin.spacexrockets.StateOfLoading;
import com.example.tin.spacexrockets.models.rocket.RocketResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    // This is how we keep an instance of the latest arrayList saved in the ViewModel
    private ArrayList<RocketResponse> mRocketResponse = new ArrayList<>();

    private MutableLiveData<ArrayList<RocketResponse>> rocketsLiveData;
    private MutableLiveData<StateOfLoading.stateCodes> statesLiveData;
    private MutableLiveData<ArrayList<RocketResponse>> filteredRocketsLiveData;

    @Inject
    RestService restService;

    public MainViewModel(@NonNull Application application) {
        super(application);

        ((AppClass) application).getAndroidComponent().inject(this);
    }

    public MutableLiveData<ArrayList<RocketResponse>> listenToFilterChanges(boolean filterActive) {

        if (filteredRocketsLiveData == null) {

            filteredRocketsLiveData = new MutableLiveData<>();
        }

        if (filterActive) {

            ArrayList<RocketResponse> filteredResponse;
            // if user wants to see only Active rockets
            filteredResponse = FilterRocketResponse.filterRocketResponse(mRocketResponse);

            filteredRocketsLiveData.postValue(filteredResponse);
        } else {

            filteredRocketsLiveData.postValue(mRocketResponse);

        }
        return filteredRocketsLiveData;
    }


    public MutableLiveData<ArrayList<RocketResponse>> listenToDataChanges() {

        if (rocketsLiveData == null) {

            rocketsLiveData = new MutableLiveData<>();

            loadItems();
        }
        return rocketsLiveData;
    }

    // Create a MutableLiveData that will be used to send messages to Activity, the Activity will have a switch statement to instruct it on what to do with each message.
    public MutableLiveData<StateOfLoading.stateCodes> listenToStatesChanges() {

        if (statesLiveData == null) {

            statesLiveData = new MutableLiveData<>();

            loadItems();
        }
        return statesLiveData;
    }

    public void loadItems() {


        statesLiveData.postValue(new StateOfLoading.stateCodes(0, "loading"));

        restService.getRockets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<RocketResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArrayList<RocketResponse> rocketResponse) {

                        mRocketResponse.clear();
                        mRocketResponse.addAll(rocketResponse);
                        rocketsLiveData.postValue(rocketResponse);
                        Log.d(TAG, "RocketResponse: " + rocketResponse);
                        statesLiveData.postValue(new StateOfLoading.stateCodes(1, "loadingComplete"));

                    }

                    @Override
                    public void onError(Throwable e) {

                        statesLiveData.postValue(new StateOfLoading.stateCodes(2, "loadingFailed"));

                        Log.e("MainViewModel", "onError: error while load listings " + Log.getStackTraceString(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
