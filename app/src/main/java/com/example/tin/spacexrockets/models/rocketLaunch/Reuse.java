
package com.example.tin.spacexrockets.models.rocketLaunch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Reuse implements Parcelable
{

    @SerializedName("core")
    @Expose
    private Boolean core;
    @SerializedName("side_core1")
    @Expose
    private Boolean sideCore1;
    @SerializedName("side_core2")
    @Expose
    private Boolean sideCore2;
    @SerializedName("fairings")
    @Expose
    private Boolean fairings;
    @SerializedName("capsule")
    @Expose
    private Boolean capsule;
    public final static Creator<Reuse> CREATOR = new Creator<Reuse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Reuse createFromParcel(Parcel in) {
            return new Reuse(in);
        }

        public Reuse[] newArray(int size) {
            return (new Reuse[size]);
        }

    }
    ;

    protected Reuse(Parcel in) {
        this.core = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.sideCore1 = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.sideCore2 = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.fairings = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.capsule = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
    }

    public Reuse() {
    }

    public Boolean getCore() {
        return core;
    }

    public void setCore(Boolean core) {
        this.core = core;
    }

    public Boolean getSideCore1() {
        return sideCore1;
    }

    public void setSideCore1(Boolean sideCore1) {
        this.sideCore1 = sideCore1;
    }

    public Boolean getSideCore2() {
        return sideCore2;
    }

    public void setSideCore2(Boolean sideCore2) {
        this.sideCore2 = sideCore2;
    }

    public Boolean getFairings() {
        return fairings;
    }

    public void setFairings(Boolean fairings) {
        this.fairings = fairings;
    }

    public Boolean getCapsule() {
        return capsule;
    }

    public void setCapsule(Boolean capsule) {
        this.capsule = capsule;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(core);
        dest.writeValue(sideCore1);
        dest.writeValue(sideCore2);
        dest.writeValue(fairings);
        dest.writeValue(capsule);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "Reuse{" +
                "core=" + core +
                ", sideCore1=" + sideCore1 +
                ", sideCore2=" + sideCore2 +
                ", fairings=" + fairings +
                ", capsule=" + capsule +
                '}';
    }
}
