
package com.example.tin.spacexrockets.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Height implements Parcelable
{

    @SerializedName("meters")
    @Expose
    private double meters;
    @SerializedName("feet")
    @Expose
    private double feet;
    public final static Creator<Height> CREATOR = new Creator<Height>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Height createFromParcel(Parcel in) {
            return new Height(in);
        }

        public Height[] newArray(int size) {
            return (new Height[size]);
        }

    }
    ;

    protected Height(Parcel in) {
        this.meters = ((double) in.readValue((double.class.getClassLoader())));
        this.feet = ((double) in.readValue((double.class.getClassLoader())));
    }

    public Height() {
    }

    public double getMeters() {
        return meters;
    }

    public void setMeters(double meters) {
        this.meters = meters;
    }

    public double getFeet() {
        return feet;
    }

    public void setFeet(double feet) {
        this.feet = feet;
    }

    @Override
    public String toString() {
        return "Height{" +
                "meters=" + meters +
                ", feet=" + feet +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(meters);
        dest.writeValue(feet);
    }

    public int describeContents() {
        return  0;
    }

}
