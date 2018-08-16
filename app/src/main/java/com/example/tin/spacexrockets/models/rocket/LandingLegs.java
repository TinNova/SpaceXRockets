
package com.example.tin.spacexrockets.models.rocket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LandingLegs implements Parcelable
{

    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("material")
    @Expose
    private String material;
    public final static Creator<LandingLegs> CREATOR = new Creator<LandingLegs>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LandingLegs createFromParcel(Parcel in) {
            return new LandingLegs(in);
        }

        public LandingLegs[] newArray(int size) {
            return (new LandingLegs[size]);
        }

    }
    ;

    protected LandingLegs(Parcel in) {
        this.number = ((int) in.readValue((int.class.getClassLoader())));
        this.material = ((String) in.readValue((String.class.getClassLoader())));
    }

    public LandingLegs() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "LandingLegs{" +
                "number=" + number +
                ", material='" + material + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(number);
        dest.writeValue(material);
    }

    public int describeContents() {
        return  0;
    }

}
