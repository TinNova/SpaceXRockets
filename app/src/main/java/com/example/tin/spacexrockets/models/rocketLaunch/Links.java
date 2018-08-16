
package com.example.tin.spacexrockets.models.rocketLaunch;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links implements Parcelable
{

    @SerializedName("mission_patch")
    @Expose
    private String missionPatch;
    @SerializedName("mission_patch_small")
    @Expose
    private String missionPatchSmall;
    @SerializedName("article_link")
    @Expose
    private String articleLink;
    @SerializedName("wikipedia")
    @Expose
    private String wikipedia;
    @SerializedName("video_link")
    @Expose
    private String videoLink;
    @SerializedName("presskit")
    @Expose
    private String presskit;
    public final static Creator<Links> CREATOR = new Creator<Links>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Links createFromParcel(Parcel in) {
            return new Links(in);
        }

        public Links[] newArray(int size) {
            return (new Links[size]);
        }

    }
    ;

    protected Links(Parcel in) {
        this.missionPatch = ((String) in.readValue((String.class.getClassLoader())));
        this.missionPatchSmall = ((String) in.readValue((String.class.getClassLoader())));
        this.articleLink = ((String) in.readValue((String.class.getClassLoader())));
        this.wikipedia = ((String) in.readValue((String.class.getClassLoader())));
        this.videoLink = ((String) in.readValue((String.class.getClassLoader())));
        this.presskit = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Links() {
    }

    public String getMissionPatch() {
        return missionPatch;
    }

    public void setMissionPatch(String missionPatch) {
        this.missionPatch = missionPatch;
    }

    public String getMissionPatchSmall() {
        return missionPatchSmall;
    }

    public void setMissionPatchSmall(String missionPatchSmall) {
        this.missionPatchSmall = missionPatchSmall;
    }

    public String getArticleLink() {
        return articleLink;
    }

    public void setArticleLink(String articleLink) {
        this.articleLink = articleLink;
    }

    public String getWikipedia() {
        return wikipedia;
    }

    public void setWikipedia(String wikipedia) {
        this.wikipedia = wikipedia;
    }

    public String getVideoLink() {
        return videoLink;
    }

    public void setVideoLink(String videoLink) {
        this.videoLink = videoLink;
    }

    public String getPresskit() {
        return presskit;
    }

    public void setPresskit(String presskit) {
        this.presskit = presskit;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(missionPatch);
        dest.writeValue(missionPatchSmall);
        dest.writeValue(articleLink);
        dest.writeValue(wikipedia);
        dest.writeValue(videoLink);
        dest.writeValue(presskit);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "Links{" +
                "missionPatch='" + missionPatch + '\'' +
                ", missionPatchSmall='" + missionPatchSmall + '\'' +
                ", articleLink='" + articleLink + '\'' +
                ", wikipedia='" + wikipedia + '\'' +
                ", videoLink='" + videoLink + '\'' +
                ", presskit='" + presskit + '\'' +
                '}';
    }
}
