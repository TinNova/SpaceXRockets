
package com.example.tin.spacexrockets.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Thrust implements Parcelable
{

    @SerializedName("kN")
    @Expose
    private int kN;
    @SerializedName("lbf")
    @Expose
    private int lbf;
    public final static Creator<Thrust> CREATOR = new Creator<Thrust>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Thrust createFromParcel(Parcel in) {
            return new Thrust(in);
        }

        public Thrust[] newArray(int size) {
            return (new Thrust[size]);
        }

    }
    ;

    protected Thrust(Parcel in) {
        this.kN = ((int) in.readValue((int.class.getClassLoader())));
        this.lbf = ((int) in.readValue((int.class.getClassLoader())));
    }

    public Thrust() {
    }

    public int getKN() {
        return kN;
    }

    public void setKN(int kN) {
        this.kN = kN;
    }

    public int getLbf() {
        return lbf;
    }

    public void setLbf(int lbf) {
        this.lbf = lbf;
    }

    @Override
    public String toString() {
        return "Thrust{" +
                "kN=" + kN +
                ", lbf=" + lbf +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(kN);
        dest.writeValue(lbf);
    }

    public int describeContents() {
        return  0;
    }

}
