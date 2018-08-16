
package com.example.tin.spacexrockets.models.rocket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diameter implements Parcelable
{

    @SerializedName("meters")
    @Expose
    private double meters;
    @SerializedName("feet")
    @Expose
    private double feet;
    public final static Creator<Diameter> CREATOR = new Creator<Diameter>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Diameter createFromParcel(Parcel in) {
            return new Diameter(in);
        }

        public Diameter[] newArray(int size) {
            return (new Diameter[size]);
        }

    }
    ;

    protected Diameter(Parcel in) {
        this.meters = ((double) in.readValue((double.class.getClassLoader())));
        this.feet = ((double) in.readValue((double.class.getClassLoader())));
    }

    public Diameter() {
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
        return "Diameter{" +
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
