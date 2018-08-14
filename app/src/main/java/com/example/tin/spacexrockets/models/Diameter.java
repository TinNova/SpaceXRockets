
package com.example.tin.spacexrockets.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diameter implements Parcelable
{

    @SerializedName("meters")
    @Expose
    private int meters;
    @SerializedName("feet")
    @Expose
    private int feet;
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
        this.meters = ((int) in.readValue((int.class.getClassLoader())));
        this.feet = ((int) in.readValue((int.class.getClassLoader())));
    }

    public Diameter() {
    }

    public int getMeters() {
        return meters;
    }

    public void setMeters(int meters) {
        this.meters = meters;
    }

    public int getFeet() {
        return feet;
    }

    public void setFeet(int feet) {
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
