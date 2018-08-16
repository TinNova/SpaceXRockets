
package com.example.tin.spacexrockets.models.rocket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompositeFairing implements Parcelable
{

    @SerializedName("height")
    @Expose
    private Height_ height;
    @SerializedName("diameter")
    @Expose
    private Diameter_ diameter;
    public final static Creator<CompositeFairing> CREATOR = new Creator<CompositeFairing>() {


        @SuppressWarnings({
            "unchecked"
        })
        public CompositeFairing createFromParcel(Parcel in) {
            return new CompositeFairing(in);
        }

        public CompositeFairing[] newArray(int size) {
            return (new CompositeFairing[size]);
        }

    }
    ;

    protected CompositeFairing(Parcel in) {
        this.height = ((Height_) in.readValue((Height_.class.getClassLoader())));
        this.diameter = ((Diameter_) in.readValue((Diameter_.class.getClassLoader())));
    }

    public CompositeFairing() {
    }

    public Height_ getHeight() {
        return height;
    }

    public void setHeight(Height_ height) {
        this.height = height;
    }

    public Diameter_ getDiameter() {
        return diameter;
    }

    public void setDiameter(Diameter_ diameter) {
        this.diameter = diameter;
    }

    @Override
    public String toString() {
        return "CompositeFairing{" +
                "height=" + height +
                ", diameter=" + diameter +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(height);
        dest.writeValue(diameter);
    }

    public int describeContents() {
        return  0;
    }

}
