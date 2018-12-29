package com.ccl.yuedu.bean;

import android.os.Parcel;
import android.os.Parcelable;

import lombok.Data;

/**
 * Created by chencanlin on 2018/12/25 15:46
 */
@Data
public class BookCategoryFilterBean implements Parcelable {
    public String type;
    public String filterCondition;
    public String major;

    public BookCategoryFilterBean(String type, String filterCondition, String major) {
        this.type = type;
        this.filterCondition = filterCondition;
        this.major = major;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.filterCondition);
        dest.writeString(this.major);
    }

    protected BookCategoryFilterBean(Parcel in) {
        this.type = in.readString();
        this.filterCondition = in.readString();
        this.major = in.readString();
    }

    public static final Creator<BookCategoryFilterBean> CREATOR = new Creator<BookCategoryFilterBean>() {
        @Override
        public BookCategoryFilterBean createFromParcel(Parcel source) {
            return new BookCategoryFilterBean(source);
        }

        @Override
        public BookCategoryFilterBean[] newArray(int size) {
            return new BookCategoryFilterBean[size];
        }
    };
}
