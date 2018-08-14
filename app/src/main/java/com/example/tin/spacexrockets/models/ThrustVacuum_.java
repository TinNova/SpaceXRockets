
package com.example.tin.spacexrockets.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThrustVacuum_ implements Parcelable
{

    @SerializedName("kN")
    @Expose
    private int kN;
    @SerializedName("lbf")
    @Expose
    private int lbf;
    public final static Creator<ThrustVacuum_> CREATOR = new Creator<ThrustVacuum_>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ThrustVacuum_ createFromParcel(Parcel in) {
            return new ThrustVacuum_(in);
        }

        public ThrustVacuum_[] newArray(int size) {
            return (new ThrustVacuum_[size]);
        }

    }
    ;

    protected ThrustVacuum_(Parcel in) {
        this.kN = ((int) in.readValue((int.class.getClassLoader())));
        this.lbf = ((int) in.readValue((int.class.getClassLoader())));
    }

    public ThrustVacuum_() {
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
        return "ThrustVacuum_{" +
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
