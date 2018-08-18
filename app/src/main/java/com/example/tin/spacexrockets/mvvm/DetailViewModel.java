package com.example.tin.spacexrockets.mvvm;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.tin.spacexrockets.AppClass;
import com.example.tin.spacexrockets.RestService;
import com.example.tin.spacexrockets.StateOfLoading;
import com.example.tin.spacexrockets.models.rocketLaunch.RocketLaunchResponse;

import java.util.ArrayList;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class DetailViewModel extends AndroidViewModel {

    private static final String TAG = DetailViewModel.class.getSimpleName();

    private String mRocketId;

    private MutableLiveData<ArrayList<RocketLaunchResponse>> rocketLaunchesLiveData;
    private MutableLiveData<StateOfLoading.stateCodes> statesLiveData;

    @Inject
    RestService restService;

    public DetailViewModel(@NonNull Application application) {
        super(application);

        ((AppClass) application).getAndroidComponent().inject(this);

    }


    public MutableLiveData<ArrayList<RocketLaunchResponse>> listenToDataChanges(String rocketId) {

        mRocketId = rocketId;
        Log.d(TAG, "listenToDataChanges(), rocketId: " + rocketId);
        Log.d(TAG, "listenToDataChanges(), mRocketId: " + mRocketId);


        if (rocketLaunchesLiveData == null) {

            rocketLaunchesLiveData = new MutableLiveData<>();

            loadItems(mRocketId);
        }

        return rocketLaunchesLiveData;
    }

    // Create a MutableLiveData that will be used to send messages to Activity, the Activity will have a switch statement to instruct it on what to do with each message.
    public MutableLiveData<StateOfLoading.stateCodes> listenToStatesChanges(String rocketId) {

        mRocketId = rocketId;

        if (statesLiveData == null) {

            statesLiveData = new MutableLiveData<>();

            loadItems(mRocketId);
        }
        return statesLiveData;
    }

    public void loadItems(String rocketId) {

        statesLiveData.postValue(new StateOfLoading.stateCodes(0, "loading"));

        restService.getRocketLaunches(rocketId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<RocketLaunchResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArrayList<RocketLaunchResponse> rocketLaunchResponse) {

                        if (rocketLaunchResponse.size() != 0) {

                            rocketLaunchesLiveData.postValue(rocketLaunchResponse);
                            Log.d("DetailViewModel", "onNext, RocketLaunchResponse: " + rocketLaunchResponse);
                        } else {
                            // Arraylist is empty, so don't update the adapter
                            Log.e(TAG, "onNext, rocketLaunchResponse is empty: " + rocketLaunchResponse);
                        }

                        statesLiveData.postValue(new StateOfLoading.stateCodes(1, "loadingComplete"));
                    }

                    @Override
                    public void onError(Throwable e) {

                        statesLiveData.postValue(new StateOfLoading.stateCodes(2, "loadingFailed"));

                        Log.e("DetailViewModel", "onError: error while load listings " + Log.getStackTraceString(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
