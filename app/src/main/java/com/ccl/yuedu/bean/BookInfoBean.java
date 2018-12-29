package com.ccl.yuedu.bean;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.List;

import lombok.Data;

/**
 * Created by chencanlin on 2018/12/26 10:25
 */
@Data
public class BookInfoBean implements Parcelable {
    public String id;
    public String title;
    public String author;
    public String shortIntro;
    public String cover;
    public String site;
    public String majorCate;
    public String minorCate;
    @JSONField(name = "sizetype")
    public String sizeType;
    @JSONField(name = "superscript")
    public String superScript;
    public String allowMonthly;
    public String banned;
    public String latelyFollower;
    public String retentionRatio;
    public String lastChapter;
    public List<String> tags;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        if (!TextUtils.isEmpty(cover) && cover.contains("/agent/")) {
            String[] split = cover.split("/agent/");
            if (split.length > 1) {
                cover = split[1];
                try {
                    cover = URLDecoder.decode(cover, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }
        }
        this.cover = cover;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.title);
        dest.writeString(this.author);
        dest.writeString(this.shortIntro);
        dest.writeString(this.cover);
        dest.writeString(this.site);
        dest.writeString(this.majorCate);
        dest.writeString(this.minorCate);
        dest.writeString(this.sizeType);
        dest.writeString(this.superScript);
        dest.writeString(this.allowMonthly);
        dest.writeString(this.banned);
        dest.writeString(this.latelyFollower);
        dest.writeString(this.retentionRatio);
        dest.writeString(this.lastChapter);
        dest.writeStringList(this.tags);
    }

    public BookInfoBean() {
    }

    protected BookInfoBean(Parcel in) {
        this.id = in.readString();
        this.title = in.readString();
        this.author = in.readString();
        this.shortIntro = in.readString();
        this.cover = in.readString();
        this.site = in.readString();
        this.majorCate = in.readString();
        this.minorCate = in.readString();
        this.sizeType = in.readString();
        this.superScript = in.readString();
        this.allowMonthly = in.readString();
        this.banned = in.readString();
        this.latelyFollower = in.readString();
        this.retentionRatio = in.readString();
        this.lastChapter = in.readString();
        this.tags = in.createStringArrayList();
    }

    public static final Creator<BookInfoBean> CREATOR = new Creator<BookInfoBean>() {
        @Override
        public BookInfoBean createFromParcel(Parcel source) {
            return new BookInfoBean(source);
        }

        @Override
        public BookInfoBean[] newArray(int size) {
            return new BookInfoBean[size];
        }
    };
}
