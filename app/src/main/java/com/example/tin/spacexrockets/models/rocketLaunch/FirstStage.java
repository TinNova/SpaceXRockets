
package com.example.tin.spacexrockets.models.rocketLaunch;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FirstStage implements Parcelable
{

    @SerializedName("cores")
    @Expose
    private List<Core> cores = null;
    public final static Creator<FirstStage> CREATOR = new Creator<FirstStage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public FirstStage createFromParcel(Parcel in) {
            return new FirstStage(in);
        }

        public FirstStage[] newArray(int size) {
            return (new FirstStage[size]);
        }

    }
    ;

    protected FirstStage(Parcel in) {
        in.readList(this.cores, (Core.class.getClassLoader()));
    }

    public FirstStage() {
    }

    public List<Core> getCores() {
        return cores;
    }

    public void setCores(List<Core> cores) {
        this.cores = cores;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(cores);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "FirstStage{" +
                "cores=" + cores +
                '}';
    }
}
