
package com.example.tin.spacexrockets.models.rocketLaunch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Core implements Parcelable
{

    @SerializedName("core_serial")
    @Expose
    private String coreSerial;
    @SerializedName("flight")
    @Expose
    private int flight;
    @SerializedName("block")
    @Expose
    private Object block;
    @SerializedName("reused")
    @Expose
    private boolean reused;
    @SerializedName("land_success")
    @Expose
    private boolean landSuccess;
    @SerializedName("landing_type")
    @Expose
    private Object landingType;
    @SerializedName("landing_vehicle")
    @Expose
    private Object landingVehicle;
    public final static Creator<Core> CREATOR = new Creator<Core>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Core createFromParcel(Parcel in) {
            return new Core(in);
        }

        public Core[] newArray(int size) {
            return (new Core[size]);
        }

    }
    ;

    protected Core(Parcel in) {
        this.coreSerial = ((String) in.readValue((String.class.getClassLoader())));
        this.flight = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.block = ((Object) in.readValue((Object.class.getClassLoader())));
        this.reused = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.landSuccess = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.landingType = ((Object) in.readValue((Object.class.getClassLoader())));
        this.landingVehicle = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Core() {
    }

    public String getCoreSerial() {
        return coreSerial;
    }

    public void setCoreSerial(String coreSerial) {
        this.coreSerial = coreSerial;
    }

    public int getFlight() {
        return flight;
    }

    public void setFlight(Integer flight) {
        this.flight = flight;
    }

    public Object getBlock() {
        return block;
    }

    public void setBlock(Object block) {
        this.block = block;
    }

    public boolean getReused() {
        return reused;
    }

    public void setReused(boolean reused) {
        this.reused = reused;
    }

    public boolean getLandSuccess() {
        return landSuccess;
    }

    public void setLandSuccess(boolean landSuccess) {
        this.landSuccess = landSuccess;
    }

    public Object getLandingType() {
        return landingType;
    }

    public void setLandingType(Object landingType) {
        this.landingType = landingType;
    }

    public Object getLandingVehicle() {
        return landingVehicle;
    }

    public void setLandingVehicle(Object landingVehicle) {
        this.landingVehicle = landingVehicle;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(coreSerial);
        dest.writeValue(flight);
        dest.writeValue(block);
        dest.writeValue(reused);
        dest.writeValue(landSuccess);
        dest.writeValue(landingType);
        dest.writeValue(landingVehicle);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "Core{" +
                "coreSerial='" + coreSerial + '\'' +
                ", flight=" + flight +
                ", block=" + block +
                ", reused=" + reused +
                ", landSuccess=" + landSuccess +
                ", landingType=" + landingType +
                ", landingVehicle=" + landingVehicle +
                '}';
    }
}
