package com.example.tin.spacexrockets;

/**
 * Created by Tin on 18/08/2018.
 */

public class StateOfLoading {

    public static class stateCodes {

        // Here we are saying, on Loading, keep the ProgressBar, on 1 Remove it, on 2 Remove it
        // Move this to utils Const class??
        public static final int LOADING = 0;
        public static final int LOADING_COMPLETE = 1;
        public static final int LOADING_ERROR = 2;

        public int code;
        public String message;

        public stateCodes(int i, String loadingState) {

            this.code = i;
            this.message = loadingState;
        }
    }
}
