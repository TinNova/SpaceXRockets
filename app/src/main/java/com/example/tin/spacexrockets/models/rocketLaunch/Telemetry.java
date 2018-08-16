
package com.example.tin.spacexrockets.models.rocketLaunch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Telemetry implements Parcelable
{

    @SerializedName("flight_club")
    @Expose
    private Object flightClub;
    public final static Creator<Telemetry> CREATOR = new Creator<Telemetry>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Telemetry createFromParcel(Parcel in) {
            return new Telemetry(in);
        }

        public Telemetry[] newArray(int size) {
            return (new Telemetry[size]);
        }

    }
    ;

    protected Telemetry(Parcel in) {
        this.flightClub = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Telemetry() {
    }

    public Object getFlightClub() {
        return flightClub;
    }

    public void setFlightClub(Object flightClub) {
        this.flightClub = flightClub;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(flightClub);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "Telemetry{" +
                "flightClub=" + flightClub +
                '}';
    }
}
