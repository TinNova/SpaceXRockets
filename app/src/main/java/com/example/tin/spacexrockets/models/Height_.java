
package com.example.tin.spacexrockets.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Height_ implements Parcelable
{

    @SerializedName("meters")
    @Expose
    private Object meters;
    @SerializedName("feet")
    @Expose
    private Object feet;
    public final static Creator<Height_> CREATOR = new Creator<Height_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Height_ createFromParcel(Parcel in) {
            return new Height_(in);
        }

        public Height_[] newArray(int size) {
            return (new Height_[size]);
        }

    }
    ;

    protected Height_(Parcel in) {
        this.meters = ((Object) in.readValue((Object.class.getClassLoader())));
        this.feet = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Height_() {
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
        return "Height_{" +
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
