
package com.example.tin.spacexrockets.models.rocketLaunch;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Payload implements Parcelable
{

    @SerializedName("payload_id")
    @Expose
    private String payloadId;
    @SerializedName("norad_id")
    @Expose
    private List<Integer> noradId = null;
    @SerializedName("reused")
    @Expose
    private boolean reused;
    @SerializedName("customers")
    @Expose
    private List<String> customers = null;
    @SerializedName("nationality")
    @Expose
    private String nationality;
    @SerializedName("manufacturer")
    @Expose
    private String manufacturer;
    @SerializedName("payload_type")
    @Expose
    private String payloadType;
    @SerializedName("payload_mass_kg")
    @Expose
    private double payloadMassKg;
    @SerializedName("payload_mass_lbs")
    @Expose
    private double payloadMassLbs;
    @SerializedName("orbit")
    @Expose
    private String orbit;
    @SerializedName("orbit_params")
    @Expose
    private OrbitParams orbitParams;
    public final static Creator<Payload> CREATOR = new Creator<Payload>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Payload createFromParcel(Parcel in) {
            return new Payload(in);
        }

        public Payload[] newArray(int size) {
            return (new Payload[size]);
        }

    }
    ;

    protected Payload(Parcel in) {
        this.payloadId = ((String) in.readValue((String.class.getClassLoader())));
        in.readList(this.noradId, (int.class.getClassLoader()));
        this.reused = ((boolean) in.readValue((boolean.class.getClassLoader())));
        in.readList(this.customers, (String.class.getClassLoader()));
        this.nationality = ((String) in.readValue((String.class.getClassLoader())));
        this.manufacturer = ((String) in.readValue((String.class.getClassLoader())));
        this.payloadType = ((String) in.readValue((String.class.getClassLoader())));
        this.payloadMassKg = ((int) in.readValue((int.class.getClassLoader())));
        this.payloadMassLbs = ((int) in.readValue((int.class.getClassLoader())));
        this.orbit = ((String) in.readValue((String.class.getClassLoader())));
        this.orbitParams = ((OrbitParams) in.readValue((OrbitParams.class.getClassLoader())));
    }

    public Payload() {
    }

    public String getPayloadId() {
        return payloadId;
    }

    public void setPayloadId(String payloadId) {
        this.payloadId = payloadId;
    }

    public List<Integer> getNoradId() {
        return noradId;
    }

    public void setNoradId(List<Integer> noradId) {
        this.noradId = noradId;
    }

    public boolean getReused() {
        return reused;
    }

    public void setReused(boolean reused) {
        this.reused = reused;
    }

    public List<String> getCustomers() {
        return customers;
    }

    public void setCustomers(List<String> customers) {
        this.customers = customers;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getPayloadType() {
        return payloadType;
    }

    public void setPayloadType(String payloadType) {
        this.payloadType = payloadType;
    }

    public double getPayloadMassKg() {
        return payloadMassKg;
    }

    public void setPayloadMassKg(int payloadMassKg) {
        this.payloadMassKg = payloadMassKg;
    }

    public double getPayloadMassLbs() {
        return payloadMassLbs;
    }

    public void setPayloadMassLbs(int payloadMassLbs) {
        this.payloadMassLbs = payloadMassLbs;
    }

    public String getOrbit() {
        return orbit;
    }

    public void setOrbit(String orbit) {
        this.orbit = orbit;
    }

    public OrbitParams getOrbitParams() {
        return orbitParams;
    }

    public void setOrbitParams(OrbitParams orbitParams) {
        this.orbitParams = orbitParams;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(payloadId);
        dest.writeList(noradId);
        dest.writeValue(reused);
        dest.writeList(customers);
        dest.writeValue(nationality);
        dest.writeValue(manufacturer);
        dest.writeValue(payloadType);
        dest.writeValue(payloadMassKg);
        dest.writeValue(payloadMassLbs);
        dest.writeValue(orbit);
        dest.writeValue(orbitParams);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "payloadId='" + payloadId + '\'' +
                ", noradId=" + noradId +
                ", reused=" + reused +
                ", customers=" + customers +
                ", nationality='" + nationality + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", payloadType='" + payloadType + '\'' +
                ", payloadMassKg=" + payloadMassKg +
                ", payloadMassLbs=" + payloadMassLbs +
                ", orbit='" + orbit + '\'' +
                ", orbitParams=" + orbitParams +
                '}';
    }
}
