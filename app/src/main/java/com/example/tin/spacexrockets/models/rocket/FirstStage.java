
package com.example.tin.spacexrockets.models.rocket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FirstStage implements Parcelable
{

    @SerializedName("reusable")
    @Expose
    private boolean reusable;
    @SerializedName("engines")
    @Expose
    private int engines;
    @SerializedName("fuel_amount_tons")
    @Expose
    private double fuelAmountTons;
    @SerializedName("burn_time_sec")
    @Expose
    private int burnTimeSec;
    @SerializedName("thrust_sea_level")
    @Expose
    private ThrustSeaLevel thrustSeaLevel;
    @SerializedName("thrust_vacuum")
    @Expose
    private ThrustVacuum thrustVacuum;
    @SerializedName("cores")
    @Expose
    private int cores;
    public final static Creator<FirstStage> CREATOR = new Creator<FirstStage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FirstStage createFromParcel(Parcel in) {
            return new FirstStage(in);
        }

        public FirstStage[] newArray(int size) {
            return (new FirstStage[size]);
        }

    }
    ;

    protected FirstStage(Parcel in) {
        this.reusable = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.engines = ((int) in.readValue((int.class.getClassLoader())));
        this.fuelAmountTons = ((double) in.readValue((double.class.getClassLoader())));
        this.burnTimeSec = ((int) in.readValue((int.class.getClassLoader())));
        this.thrustSeaLevel = ((ThrustSeaLevel) in.readValue((ThrustSeaLevel.class.getClassLoader())));
        this.thrustVacuum = ((ThrustVacuum) in.readValue((ThrustVacuum.class.getClassLoader())));
        this.cores = ((int) in.readValue((int.class.getClassLoader())));
    }

    public FirstStage() {
    }

    public boolean isReusable() {
        return reusable;
    }

    public void setReusable(boolean reusable) {
        this.reusable = reusable;
    }

    public int getEngines() {
        return engines;
    }

    public void setEngines(int engines) {
        this.engines = engines;
    }

    public double getFuelAmountTons() {
        return fuelAmountTons;
    }

    public void setFuelAmountTons(double fuelAmountTons) {
        this.fuelAmountTons = fuelAmountTons;
    }

    public int getBurnTimeSec() {
        return burnTimeSec;
    }

    public void setBurnTimeSec(int burnTimeSec) {
        this.burnTimeSec = burnTimeSec;
    }

    public ThrustSeaLevel getThrustSeaLevel() {
        return thrustSeaLevel;
    }

    public void setThrustSeaLevel(ThrustSeaLevel thrustSeaLevel) {
        this.thrustSeaLevel = thrustSeaLevel;
    }

    public ThrustVacuum getThrustVacuum() {
        return thrustVacuum;
    }

    public void setThrustVacuum(ThrustVacuum thrustVacuum) {
        this.thrustVacuum = thrustVacuum;
    }

    public int getCores() {
        return cores;
    }

    public void setCores(int cores) {
        this.cores = cores;
    }

    @Override
    public String toString() {
        return "FirstStage{" +
                "reusable=" + reusable +
                ", engines=" + engines +
                ", fuelAmountTons=" + fuelAmountTons +
                ", burnTimeSec=" + burnTimeSec +
                ", thrustSeaLevel=" + thrustSeaLevel +
                ", thrustVacuum=" + thrustVacuum +
                ", cores=" + cores +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(reusable);
        dest.writeValue(engines);
        dest.writeValue(fuelAmountTons);
        dest.writeValue(burnTimeSec);
        dest.writeValue(thrustSeaLevel);
        dest.writeValue(thrustVacuum);
        dest.writeValue(cores);
    }

    public int describeContents() {
        return  0;
    }

}
