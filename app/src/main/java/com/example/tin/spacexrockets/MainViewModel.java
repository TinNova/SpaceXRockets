package com.example.tin.spacexrockets;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.tin.spacexrockets.models.rocket.RocketResponse;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class MainViewModel extends AndroidViewModel {

    private static final String TAG = MainViewModel.class.getSimpleName();

    private MutableLiveData<ArrayList<RocketResponse>> rocketsLiveData;
    private MutableLiveData<stateCodes> statesLiveData;

    // This is how we keep an instance of the latest arrayList saved in the ViewModel
    private ArrayList<RocketResponse> rocketResponseSavedInViewModel = new ArrayList<>();


    @Inject
    RestService restService;

    public MainViewModel(@NonNull Application application) {
        super(application);

        ((AppClass) application).getAndroidComponent().inject(this);

    }

    public MutableLiveData<ArrayList<RocketResponse>> listenToDataChanges() {

        if (rocketsLiveData == null) {

            rocketsLiveData = new MutableLiveData<>();

            loadItems();
        }

        return rocketsLiveData;
    }

    // Create a MutableLiveData that will be used to send messages to Activity, the Activity will have a switch statement to instruct it on what to do with each message.
    public MutableLiveData<stateCodes> listenToStatesLiveData() {

        if (statesLiveData == null) {

            statesLiveData = new MutableLiveData<>();

            loadItems();
        }

        return statesLiveData;
    }

    public class stateCodes {

        int code;
        String message;

        // Here we are saying, on Loading, keep the ProgressBar, on 1 Remove it, on 2 Remove it
        public static final int LOADING = 0;
        public static final int LOADING_COMPLETE = 1;
        public static final int LOADING_ERROR = 2;

        public stateCodes(int i, String loadingState) {

            this.code = i;
            this.message = loadingState;
        }
    }

    // This is how we will filter a list, the rocketResponse is saved in the ViewModel, so we only need the Activity
    // to send us a String with the instructions (filter large to small, or filter by year ect...
    // With these instructions we can call a class to do the business logic, then pass the ArrayList back through the rocketsLiveData listeners.
    public void filterList(String filter){

        if (filter.length() == 0){

            rocketsLiveData.postValue(rocketResponseSavedInViewModel);
        } else {

            //Connect to a class that filters the data

            // Return list of filteredList
            rocketsLiveData.postValue(filteredList);
        }
    }

    public void loadItems() {

        statesLiveData.postValue(new stateCodes(0, "loading"));

        restService.getRockets()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<RocketResponse>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArrayList<RocketResponse> rocketResponse) {

                        rocketResponseSavedInViewModel.clear();
                        rocketResponseSavedInViewModel.addAll(rocketResponse);
                        //so here we tell our live data to NOTIFY ALL SUBSCRIBERS that data was changed
                        rocketsLiveData.postValue(rocketResponse);
                        Log.d(TAG, "RocketResponse: " + rocketResponse);
                        statesLiveData.postValue(new stateCodes(1, "loadingComplete"));

                    }

                    @Override
                    public void onError(Throwable e) {

                        statesLiveData.postValue(new stateCodes(2, "loadingFailed"));

                        Log.e("MainViewModel", "onError: error while load listings " + Log.getStackTraceString(e));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
