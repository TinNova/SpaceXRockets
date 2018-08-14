
package com.example.tin.spacexrockets.models;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RocketResponse implements Parcelable {

    @SerializedName("rocketid")
    @Expose
    private int rocketid;
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("active")
    @Expose
    private boolean active;
    @SerializedName("stages")
    @Expose
    private int stages;
    @SerializedName("boosters")
    @Expose
    private int boosters;
    @SerializedName("cost_per_launch")
    @Expose
    private int costPerLaunch;
    @SerializedName("success_rate_pct")
    @Expose
    private int successRatePct;
    @SerializedName("first_flight")
    @Expose
    private String firstFlight;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("company")
    @Expose
    private String company;
    @SerializedName("height")
    @Expose
    private Height height;
    @SerializedName("diameter")
    @Expose
    private Diameter diameter;
    @SerializedName("mass")
    @Expose
    private Mass mass;
    @SerializedName("payload_weights")
    @Expose
    private List<PayloadWeight> payloadWeights = null;
    @SerializedName("first_stage")
    @Expose
    private FirstStage firstStage;
    @SerializedName("second_stage")
    @Expose
    private SecondStage secondStage;
    @SerializedName("engines")
    @Expose
    private Engines engines;
    @SerializedName("landing_legs")
    @Expose
    private LandingLegs landingLegs;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("description")
    @Expose
    private String description;
    public final static Creator<RocketResponse> CREATOR = new Creator<RocketResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RocketResponse createFromParcel(Parcel in) {
            return new RocketResponse(in);
        }

        public RocketResponse[] newArray(int size) {
            return (new RocketResponse[size]);
        }

    }
    ;

    protected RocketResponse(Parcel in) {
        this.rocketid = ((int) in.readValue((int.class.getClassLoader())));
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.type = ((String) in.readValue((String.class.getClassLoader())));
        this.active = ((boolean) in.readValue((boolean.class.getClassLoader())));
        this.stages = ((int) in.readValue((int.class.getClassLoader())));
        this.boosters = ((int) in.readValue((int.class.getClassLoader())));
        this.costPerLaunch = ((int) in.readValue((int.class.getClassLoader())));
        this.successRatePct = ((int) in.readValue((int.class.getClassLoader())));
        this.firstFlight = ((String) in.readValue((String.class.getClassLoader())));
        this.country = ((String) in.readValue((String.class.getClassLoader())));
        this.company = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((Height) in.readValue((Height.class.getClassLoader())));
        this.diameter = ((Diameter) in.readValue((Diameter.class.getClassLoader())));
        this.mass = ((Mass) in.readValue((Mass.class.getClassLoader())));
        in.readList(this.payloadWeights, (PayloadWeight.class.getClassLoader()));
        this.firstStage = ((FirstStage) in.readValue((FirstStage.class.getClassLoader())));
        this.secondStage = ((SecondStage) in.readValue((SecondStage.class.getClassLoader())));
        this.engines = ((Engines) in.readValue((Engines.class.getClassLoader())));
        this.landingLegs = ((LandingLegs) in.readValue((LandingLegs.class.getClassLoader())));
        this.wikipedia = ((String) in.readValue((String.class.getClassLoader())));
        this.description = ((String) in.readValue((String.class.getClassLoader())));
    }

    public RocketResponse() {
    }

    public int getRocketid() {
        return rocketid;
    }

    public void setRocketid(int rocketid) {
        this.rocketid = rocketid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getStages() {
        return stages;
    }

    public void setStages(int stages) {
        this.stages = stages;
    }

    public int getBoosters() {
        return boosters;
    }

    public void setBoosters(int boosters) {
        this.boosters = boosters;
    }

    public int getCostPerLaunch() {
        return costPerLaunch;
    }

    public void setCostPerLaunch(int costPerLaunch) {
        this.costPerLaunch = costPerLaunch;
    }

    public int getSuccessRatePct() {
        return successRatePct;
    }

    public void setSuccessRatePct(int successRatePct) {
        this.successRatePct = successRatePct;
    }

    public String getFirstFlight() {
        return firstFlight;
    }

    public void setFirstFlight(String firstFlight) {
        this.firstFlight = firstFlight;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public Diameter getDiameter() {
        return diameter;
    }

    public void setDiameter(Diameter diameter) {
        this.diameter = diameter;
    }

    public Mass getMass() {
        return mass;
    }

    public void setMass(Mass mass) {
        this.mass = mass;
    }

    public List<PayloadWeight> getPayloadWeights() {
        return payloadWeights;
    }

    public void setPayloadWeights(List<PayloadWeight> payloadWeights) {
        this.payloadWeights = payloadWeights;
    }

    public FirstStage getFirstStage() {
        return firstStage;
    }

    public void setFirstStage(FirstStage firstStage) {
        this.firstStage = firstStage;
    }

    public SecondStage getSecondStage() {
        return secondStage;
    }

    public void setSecondStage(SecondStage secondStage) {
        this.secondStage = secondStage;
    }

    public Engines getEngines() {
        return engines;
    }

    public void setEngines(Engines engines) {
        this.engines = engines;
    }

    public LandingLegs getLandingLegs() {
        return landingLegs;
    }

    public void setLandingLegs(LandingLegs landingLegs) {
        this.landingLegs = landingLegs;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "RocketResponse{" +
                "rocketid=" + rocketid +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", active=" + active +
                ", stages=" + stages +
                ", boosters=" + boosters +
                ", costPerLaunch=" + costPerLaunch +
                ", successRatePct=" + successRatePct +
                ", firstFlight='" + firstFlight + '\'' +
                ", country='" + country + '\'' +
                ", company='" + company + '\'' +
                ", height=" + height +
                ", diameter=" + diameter +
                ", mass=" + mass +
                ", payloadWeights=" + payloadWeights +
                ", firstStage=" + firstStage +
                ", secondStage=" + secondStage +
                ", engines=" + engines +
                ", landingLegs=" + landingLegs +
                ", wikipedia='" + wikipedia + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(rocketid);
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(type);
        dest.writeValue(active);
        dest.writeValue(stages);
        dest.writeValue(boosters);
        dest.writeValue(costPerLaunch);
        dest.writeValue(successRatePct);
        dest.writeValue(firstFlight);
        dest.writeValue(country);
        dest.writeValue(company);
        dest.writeValue(height);
        dest.writeValue(diameter);
        dest.writeValue(mass);
        dest.writeList(payloadWeights);
        dest.writeValue(firstStage);
        dest.writeValue(secondStage);
        dest.writeValue(engines);
        dest.writeValue(landingLegs);
        dest.writeValue(wikipedia);
        dest.writeValue(description);
    }

    public int describeContents() {
        return  0;
    }

}
