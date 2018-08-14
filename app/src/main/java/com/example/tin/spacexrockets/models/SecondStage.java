
package com.example.tin.spacexrockets.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecondStage implements Parcelable
{

    @SerializedName("engines")
    @Expose
    private int engines;
    @SerializedName("fuel_amount_tons")
    @Expose
    private int fuelAmountTons;
    @SerializedName("burn_time_sec")
    @Expose
    private int burnTimeSec;
    @SerializedName("thrust")
    @Expose
    private Thrust thrust;
    @SerializedName("payloads")
    @Expose
    private Payloads payloads;
    public final static Creator<SecondStage> CREATOR = new Creator<SecondStage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SecondStage createFromParcel(Parcel in) {
            return new SecondStage(in);
        }

        public SecondStage[] newArray(int size) {
            return (new SecondStage[size]);
        }

    }
    ;

    protected SecondStage(Parcel in) {
        this.engines = ((int) in.readValue((int.class.getClassLoader())));
        this.fuelAmountTons = ((int) in.readValue((int.class.getClassLoader())));
        this.burnTimeSec = ((int) in.readValue((int.class.getClassLoader())));
        this.thrust = ((Thrust) in.readValue((Thrust.class.getClassLoader())));
        this.payloads = ((Payloads) in.readValue((Payloads.class.getClassLoader())));
    }

    public SecondStage() {
    }

    public int getEngines() {
        return engines;
    }

    public void setEngines(int engines) {
        this.engines = engines;
    }

    public int getFuelAmountTons() {
        return fuelAmountTons;
    }

    public void setFuelAmountTons(int fuelAmountTons) {
        this.fuelAmountTons = fuelAmountTons;
    }

    public int getBurnTimeSec() {
        return burnTimeSec;
    }

    public void setBurnTimeSec(int burnTimeSec) {
        this.burnTimeSec = burnTimeSec;
    }

    public Thrust getThrust() {
        return thrust;
    }

    public void setThrust(Thrust thrust) {
        this.thrust = thrust;
    }

    public Payloads getPayloads() {
        return payloads;
    }

    public void setPayloads(Payloads payloads) {
        this.payloads = payloads;
    }

    @Override
    public String toString() {
        return "SecondStage{" +
                "engines=" + engines +
                ", fuelAmountTons=" + fuelAmountTons +
                ", burnTimeSec=" + burnTimeSec +
                ", thrust=" + thrust +
                ", payloads=" + payloads +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(engines);
        dest.writeValue(fuelAmountTons);
        dest.writeValue(burnTimeSec);
        dest.writeValue(thrust);
        dest.writeValue(payloads);
    }

    public int describeContents() {
        return  0;
    }

}
