
package com.example.tin.spacexrockets.models.rocketLaunch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LaunchSite implements Parcelable
{

    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("site_name")
    @Expose
    private String siteName;
    @SerializedName("site_name_long")
    @Expose
    private String siteNameLong;
    public final static Creator<LaunchSite> CREATOR = new Creator<LaunchSite>() {


        @SuppressWarnings({
            "unchecked"
        })
        public LaunchSite createFromParcel(Parcel in) {
            return new LaunchSite(in);
        }

        public LaunchSite[] newArray(int size) {
            return (new LaunchSite[size]);
        }

    }
    ;

    protected LaunchSite(Parcel in) {
        this.siteId = ((String) in.readValue((String.class.getClassLoader())));
        this.siteName = ((String) in.readValue((String.class.getClassLoader())));
        this.siteNameLong = ((String) in.readValue((String.class.getClassLoader())));
    }

    public LaunchSite() {
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public String getSiteNameLong() {
        return siteNameLong;
    }

    public void setSiteNameLong(String siteNameLong) {
        this.siteNameLong = siteNameLong;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(siteId);
        dest.writeValue(siteName);
        dest.writeValue(siteNameLong);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "LaunchSite{" +
                "siteId='" + siteId + '\'' +
                ", siteName='" + siteName + '\'' +
                ", siteNameLong='" + siteNameLong + '\'' +
                '}';
    }
}
