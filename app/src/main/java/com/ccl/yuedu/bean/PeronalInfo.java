package com.ccl.yuedu.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by chencanlin on 2018/12/20 14:35
 */
public class PeronalInfo implements Parcelable {
    public String avatarUrl;
    public String name;
    public String intro;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.avatarUrl);
        dest.writeString(this.name);
        dest.writeString(this.intro);
    }

    public PeronalInfo() {
    }

    protected PeronalInfo(Parcel in) {
        this.avatarUrl = in.readString();
        this.name = in.readString();
        this.intro = in.readString();
    }

    public static final Creator<PeronalInfo> CREATOR = new Creator<PeronalInfo>() {
        @Override
        public PeronalInfo createFromParcel(Parcel source) {
            return new PeronalInfo(source);
        }

        @Override
        public PeronalInfo[] newArray(int size) {
            return new PeronalInfo[size];
        }
    };
}
