
package com.example.tin.spacexrockets.models.rocketLaunch;

import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecondStage implements Parcelable
{

    @SerializedName("block")
    @Expose
    private Integer block;
    @SerializedName("payloads")
    @Expose
    private List<Payload> payloads = null;
    public final static Creator<SecondStage> CREATOR = new Creator<SecondStage>() {


        @SuppressWarnings({
            "unchecked"
        })
        public SecondStage createFromParcel(Parcel in) {
            return new SecondStage(in);
        }

        public SecondStage[] newArray(int size) {
            return (new SecondStage[size]);
        }

    }
    ;

    protected SecondStage(Parcel in) {
        this.block = ((Integer) in.readValue((Integer.class.getClassLoader())));
        in.readList(this.payloads, (Payload.class.getClassLoader()));
    }

    public SecondStage() {
    }

    public Integer getBlock() {
        return block;
    }

    public void setBlock(Integer block) {
        this.block = block;
    }

    public List<Payload> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<Payload> payloads) {
        this.payloads = payloads;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(block);
        dest.writeList(payloads);
    }

    public int describeContents() {
        return  0;
    }

    @Override
    public String toString() {
        return "SecondStage{" +
                "block=" + block +
                ", payloads=" + payloads +
                '}';
    }
}
