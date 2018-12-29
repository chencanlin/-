package com.ccl.yuedu.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.alibaba.fastjson.annotation.JSONField;

import lombok.Data;

/**
 * Created by chencanlin on 2018/12/24 17:20
 */
@Data
public class BookCategoryBean  implements Parcelable {
    @JSONField
    public String name;
    @JSONField
    public String bookCount;
    @JSONField
    public String monthlyCount;
    @JSONField
    public String icon;
    @JSONField
    public String bookCover;

    public BookCategoryBean() {
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.bookCount);
        dest.writeString(this.monthlyCount);
        dest.writeString(this.icon);
        dest.writeString(this.bookCover);
    }

    protected BookCategoryBean(Parcel in) {
        this.name = in.readString();
        this.bookCount = in.readString();
        this.monthlyCount = in.readString();
        this.icon = in.readString();
        this.bookCover = in.readString();
    }

    public static final Creator<BookCategoryBean> CREATOR = new Creator<BookCategoryBean>() {
        @Override
        public BookCategoryBean createFromParcel(Parcel source) {
            return new BookCategoryBean(source);
        }

        @Override
        public BookCategoryBean[] newArray(int size) {
            return new BookCategoryBean[size];
        }
    };
}
