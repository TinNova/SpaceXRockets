
package com.example.tin.spacexrockets.models.rocket;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PayloadWeight implements Parcelable
{

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("kg")
    @Expose
    private int kg;
    @SerializedName("lb")
    @Expose
    private int lb;
    public final static Creator<PayloadWeight> CREATOR = new Creator<PayloadWeight>() {


        @SuppressWarnings({
            "unchecked"
        })
        public PayloadWeight createFromParcel(Parcel in) {
            return new PayloadWeight(in);
        }

        public PayloadWeight[] newArray(int size) {
            return (new PayloadWeight[size]);
        }

    }
    ;

    protected PayloadWeight(Parcel in) {
        this.id = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
        this.kg = ((int) in.readValue((int.class.getClassLoader())));
        this.lb = ((int) in.readValue((int.class.getClassLoader())));
    }

    public PayloadWeight() {
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

    public int getKg() {
        return kg;
    }

    public void setKg(int kg) {
        this.kg = kg;
    }

    public int getLb() {
        return lb;
    }

    public void setLb(int lb) {
        this.lb = lb;
    }

    @Override
    public String toString() {
        return "PayloadWeight{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", kg=" + kg +
                ", lb=" + lb +
                '}';
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(id);
        dest.writeValue(name);
        dest.writeValue(kg);
        dest.writeValue(lb);
    }

    public int describeContents() {
        return  0;
    }

}
