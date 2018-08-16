
package com.example.tin.spacexrockets.models.rocket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Diameter_ implements Parcelable
{

    @SerializedName("meters")
    @Expose
    private Object meters;
    @SerializedName("feet")
    @Expose
    private Object feet;
    public final static Creator<Diameter_> CREATOR = new Creator<Diameter_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Diameter_ createFromParcel(Parcel in) {
            return new Diameter_(in);
        }

        public Diameter_[] newArray(int size) {
            return (new Diameter_[size]);
        }

    }
    ;

    protected Diameter_(Parcel in) {
        this.meters = ((Object) in.readValue((Object.class.getClassLoader())));
        this.feet = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Diameter_() {
    }

    public Object getMeters() {
        return meters;
    }

    public void setMeters(Object meters) {
        this.meters = meters;
    }

    public Object getFeet() {
        return feet;
    }

    public void setFeet(Object feet) {
        this.feet = feet;
    }

    @Override
    public String toString() {
        return "Diameter_{" +
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
