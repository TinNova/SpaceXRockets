
package com.example.tin.spacexrockets.models.rocketLaunch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RocketLaunchResponse implements Parcelable
{

    @SerializedName("flight_number")
    @Expose
    private Integer flightNumber;
    @SerializedName("mission_name")
    @Expose
    private String missionName;
    @SerializedName("upcoming")
    @Expose
    private Boolean upcoming;
    @SerializedName("launch_year")
    @Expose
    private String launchYear;
    @SerializedName("launch_date_unix")
    @Expose
    private Integer launchDateUnix;
    @SerializedName("launch_date_utc")
    @Expose
    private String launchDateUtc;
    @SerializedName("launch_date_local")
    @Expose
    private String launchDateLocal;
    @SerializedName("rocket")
    @Expose
    private Rocket rocket;
    @SerializedName("telemetry")
    @Expose
    private Telemetry telemetry;
    @SerializedName("reuse")
    @Expose
    private Reuse reuse;
    @SerializedName("launch_site")
    @Expose
    private LaunchSite launchSite;
    @SerializedName("launch_success")
    @Expose
    private Boolean launchSuccess;
    @SerializedName("links")
    @Expose
    private Links links;
    @SerializedName("details")
    @Expose
    private Object details;
    @SerializedName("static_fire_date_utc")
    @Expose
    private Object staticFireDateUtc;
    public final static Creator<RocketLaunchResponse> CREATOR = new Creator<RocketLaunchResponse>() {


        @SuppressWarnings({
            "unchecked"
        })
        public RocketLaunchResponse createFromParcel(Parcel in) {
            return new RocketLaunchResponse(in);
        }

        public RocketLaunchResponse[] newArray(int size) {
            return (new RocketLaunchResponse[size]);
        }

    }
    ;

    protected RocketLaunchResponse(Parcel in) {
        this.flightNumber = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.missionName = ((String) in.readValue((String.class.getClassLoader())));
        this.upcoming = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.launchYear = ((String) in.readValue((String.class.getClassLoader())));
        this.launchDateUnix = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.launchDateUtc = ((String) in.readValue((String.class.getClassLoader())));
        this.launchDateLocal = ((String) in.readValue((String.class.getClassLoader())));
        this.rocket = ((Rocket) in.readValue((Rocket.class.getClassLoader())));
        this.telemetry = ((Telemetry) in.readValue((Telemetry.class.getClassLoader())));
        this.reuse = ((Reuse) in.readValue((Reuse.class.getClassLoader())));
        this.launchSite = ((LaunchSite) in.readValue((LaunchSite.class.getClassLoader())));
        this.launchSuccess = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this.links = ((Links) in.readValue((Links.class.getClassLoader())));
        this.details = ((Object) in.readValue((Object.class.getClassLoader())));
        this.staticFireDateUtc = ((Object) in.readValue((Object.class.getClassLoader())));
    }

    public RocketLaunchResponse() {
    }

    public Integer getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(Integer flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getLaunchYear() {
        return launchYear;
    }

    public void setLaunchYear(String launchYear) {
        this.launchYear = launchYear;
    }

    public Integer getLaunchDateUnix() {
        return launchDateUnix;
    }

    public void setLaunchDateUnix(Integer launchDateUnix) {
        this.launchDateUnix = launchDateUnix;
    }

    public String getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(String launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public String getLaunchDateLocal() {
        return launchDateLocal;
    }

    public void setLaunchDateLocal(String launchDateLocal) {
        this.launchDateLocal = launchDateLocal;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public Reuse getReuse() {
        return reuse;
    }

    public void setReuse(Reuse reuse) {
        this.reuse = reuse;
    }

    public LaunchSite getLaunchSite() {
        return launchSite;
    }

    public void setLaunchSite(LaunchSite launchSite) {
        this.launchSite = launchSite;
    }

    public Boolean getLaunchSuccess() {
        return launchSuccess;
    }

    public void setLaunchSuccess(Boolean launchSuccess) {
        this.launchSuccess = launchSuccess;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public Object getDetails() {
        return details;
    }

    public void setDetails(Object details) {
        this.details = details;
    }

    public Object getStaticFireDateUtc() {
        return staticFireDateUtc;
    }

    public void setStaticFireDateUtc(Object staticFireDateUtc) {
        this.staticFireDateUtc = staticFireDateUtc;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(flightNumber);
        dest.writeValue(missionName);
        dest.writeValue(upcoming);
        dest.writeValue(launchYear);
        dest.writeValue(launchDateUnix);
        dest.writeValue(launchDateUtc);
        dest.writeValue(launchDateLocal);
        dest.writeValue(rocket);
        dest.writeValue(telemetry);
        dest.writeValue(reuse);
        dest.writeValue(launchSite);
        dest.writeValue(launchSuccess);
        dest.writeValue(links);
        dest.writeValue(details);
        dest.writeValue(staticFireDateUtc);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "RocketLaunchResponse{" +
                "flightNumber=" + flightNumber +
                ", missionName='" + missionName + '\'' +
                ", upcoming=" + upcoming +
                ", launchYear='" + launchYear + '\'' +
                ", launchDateUnix=" + launchDateUnix +
                ", launchDateUtc='" + launchDateUtc + '\'' +
                ", launchDateLocal='" + launchDateLocal + '\'' +
                ", rocket=" + rocket +
                ", telemetry=" + telemetry +
                ", reuse=" + reuse +
                ", launchSite=" + launchSite +
                ", launchSuccess=" + launchSuccess +
                ", links=" + links +
                ", details=" + details +
                ", staticFireDateUtc=" + staticFireDateUtc +
                '}';
    }
}
