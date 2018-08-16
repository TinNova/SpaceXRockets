
package com.example.tin.spacexrockets.models.rocket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payloads implements Parcelable
{

    @SerializedName("option_1")
    @Expose
    private String option1;
    @SerializedName("composite_fairing")
    @Expose
    private CompositeFairing compositeFairing;
    @SerializedName("option_2")
    @Expose
    private String option2;
    public final static Creator<Payloads> CREATOR = new Creator<Payloads>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Payloads createFromParcel(Parcel in) {
            return new Payloads(in);
        }

        public Payloads[] newArray(int size) {
            return (new Payloads[size]);
        }
    };

    protected Payloads(Parcel in) {
        this.option1 = ((String) in.readValue((String.class.getClassLoader())));
        this.compositeFairing = ((CompositeFairing) in.readValue((CompositeFairing.class.getClassLoader())));
        this.option2 = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Payloads() {
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public CompositeFairing getCompositeFairing() {
        return compositeFairing;
    }

    public void setCompositeFairing(CompositeFairing compositeFairing) {
        this.compositeFairing = compositeFairing;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    @Override
    public String toString() {
        return "Payloads{" +
                "option1='" + option1 + '\'' +
                ", compositeFairing=" + compositeFairing +
                ", option2='" + option2 + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(option1);
        dest.writeValue(compositeFairing);
        dest.writeValue(option2);
    }

    public int describeContents() {
        return  0;
    }

}
