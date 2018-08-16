
package com.example.tin.spacexrockets.models.rocket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mass implements Parcelable
{

    @SerializedName("kg")
    @Expose
    private int kg;
    @SerializedName("lb")
    @Expose
    private int lb;
    public final static Creator<Mass> CREATOR = new Creator<Mass>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Mass createFromParcel(Parcel in) {
            return new Mass(in);
        }

        public Mass[] newArray(int size) {
            return (new Mass[size]);
        }

    }
    ;

    protected Mass(Parcel in) {
        this.kg = ((int) in.readValue((int.class.getClassLoader())));
        this.lb = ((int) in.readValue((int.class.getClassLoader())));
    }

    public Mass() {
    }

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public int getLb() {
        return lb;
    }

    public void setLb(int lb) {
        this.lb = lb;
    }

    @Override
    public String toString() {
        return "Mass{" +
                "kg=" + kg +
                ", lb=" + lb +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kg);
        dest.writeValue(lb);
    }

    public int describeContents() {
        return  0;
    }

}
