
package com.example.tin.spacexrockets.models.rocket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Engines implements Parcelable
{

    @SerializedName("number")
    @Expose
    private int number;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("version")
    @Expose
    private String version;
    @SerializedName("layout")
    @Expose
    private Object layout;
    @SerializedName("engine_loss_max")
    @Expose
    private Object engineLossMax;
    @SerializedName("propellant_1")
    @Expose
    private String propellant1;
    @SerializedName("propellant_2")
    @Expose
    private String propellant2;
    @SerializedName("thrust_sea_level")
    @Expose
    private ThrustSeaLevel_ thrustSeaLevel;
    @SerializedName("thrust_vacuum")
    @Expose
    private ThrustVacuum_ thrustVacuum;
    @SerializedName("thrust_to_weight")
    @Expose
    private Object thrustToWeight;
    public final static Creator<Engines> CREATOR = new Creator<Engines>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Engines createFromParcel(Parcel in) {
            return new Engines(in);
        }

        public Engines[] newArray(int size) {
            return (new Engines[size]);
        }

    }
    ;

    protected Engines(Parcel in) {
        this.number = ((int) in.readValue((int.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.version = ((String) in.readValue((String.class.getClassLoader())));
        this.layout = ((Object) in.readValue((Object.class.getClassLoader())));
        this.engineLossMax = ((Object) in.readValue((Object.class.getClassLoader())));
        this.propellant1 = ((String) in.readValue((String.class.getClassLoader())));
        this.propellant2 = ((String) in.readValue((String.class.getClassLoader())));
        this.thrustSeaLevel = ((ThrustSeaLevel_) in.readValue((ThrustSeaLevel_.class.getClassLoader())));
        this.thrustVacuum = ((ThrustVacuum_) in.readValue((ThrustVacuum_.class.getClassLoader())));
        this.thrustToWeight = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public Engines() {
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Object getLayout() {
        return layout;
    }

    public void setLayout(Object layout) {
        this.layout = layout;
    }

    public Object getEngineLossMax() {
        return engineLossMax;
    }

    public void setEngineLossMax(Object engineLossMax) {
        this.engineLossMax = engineLossMax;
    }

    public String getPropellant1() {
        return propellant1;
    }

    public void setPropellant1(String propellant1) {
        this.propellant1 = propellant1;
    }

    public String getPropellant2() {
        return propellant2;
    }

    public void setPropellant2(String propellant2) {
        this.propellant2 = propellant2;
    }

    public ThrustSeaLevel_ getThrustSeaLevel() {
        return thrustSeaLevel;
    }

    public void setThrustSeaLevel(ThrustSeaLevel_ thrustSeaLevel) {
        this.thrustSeaLevel = thrustSeaLevel;
    }

    public ThrustVacuum_ getThrustVacuum() {
        return thrustVacuum;
    }

    public void setThrustVacuum(ThrustVacuum_ thrustVacuum) {
        this.thrustVacuum = thrustVacuum;
    }

    public Object getThrustToWeight() {
        return thrustToWeight;
    }

    public void setThrustToWeight(Object thrustToWeight) {
        this.thrustToWeight = thrustToWeight;
    }

    @Override
    public String toString() {
        return "Engines{" +
                "number=" + number +
                ", type='" + type + '\'' +
                ", version='" + version + '\'' +
                ", layout=" + layout +
                ", engineLossMax=" + engineLossMax +
                ", propellant1='" + propellant1 + '\'' +
                ", propellant2='" + propellant2 + '\'' +
                ", thrustSeaLevel=" + thrustSeaLevel +
                ", thrustVacuum=" + thrustVacuum +
                ", thrustToWeight=" + thrustToWeight +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(number);
        dest.writeValue(type);
        dest.writeValue(version);
        dest.writeValue(layout);
        dest.writeValue(engineLossMax);
        dest.writeValue(propellant1);
        dest.writeValue(propellant2);
        dest.writeValue(thrustSeaLevel);
        dest.writeValue(thrustVacuum);
        dest.writeValue(thrustToWeight);
    }

    public int describeContents() {
        return  0;
    }

}
